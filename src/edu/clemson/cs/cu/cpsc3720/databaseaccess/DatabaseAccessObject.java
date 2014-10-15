package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.record.impl.ODocument;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class DatabaseAccessObject<T extends DatabaseSerializable> {
	public final ArrayList<T> objects = new ArrayList<T>();
	private static ODatabaseDocumentTx db;
	private static String user = "root";
	private static String pass = "passw0rd";
	private static boolean isOpen = false;

	static {
		db = new ODatabaseDocumentTx("remote:localhost:2424/BugSquasher");
	}

	public static void open() {
		if (!isOpen) {
			db.open(user, pass);
			isOpen = true;
		}
	}

	public static void close() {
		if (isOpen) {
			db.close();
			isOpen = false;
		}
	}

	public T query(Class<T> classOfT, String ref) {
		T ret = null;

		/* Search local cache first */
		for (T t : objects) {
			if (t.getDbId().equals(ref)) {
				ret = t;
				break;
			}
		}

		if (ret == null) {
			open();
			if (db.getMetadata().getSchema()
					.existsClass(classOfT.getSimpleName())) {
				for (ODocument doc : db.browseClass(classOfT.getSimpleName())) {
					T t = new Gson().fromJson(doc.toJSON(), classOfT);
					t.setDbId(doc.getIdentity().toString());
					if (t.getDbId().equals(ref)) {
						ret = t;
						objects.add(t);
						break;
					}
				}
			}
		}

		return ret;
	}

	public void load(Class<T> classOfT) {
		open();

		for (ODocument objDoc : db.browseClass(classOfT.getSimpleName())) {
			T obj = new Gson().fromJson(objDoc.toJSON(), classOfT);
			obj.setDbId(objDoc.getIdentity().toString());
			objects.add(obj);
		}
	}

	public void save(T t) {
		open();

		ODocument doc = new ODocument(t.getClass().getSimpleName());
		if (t.getDbId() != null)
			doc = db.getRecord(new ORecordId(t.getDbId()));
		String json = new Gson().toJson(t);
		doc.fromJSON(json);
		t.setDbId(doc.save().getIdentity().toString());
	}
}
