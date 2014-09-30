package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.record.impl.ODocument;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class DatabaseAccessObject<T extends DatabaseSerializable> {
	protected ArrayList<T> objects = new ArrayList<T>();
	private static ODatabaseDocumentTx db;
	private static String user = "root";
	private static String pass = "passw0rd";

	static {
		db = new ODatabaseDocumentTx("remote:localhost:2424/BugSquasher");
	}

	public void load(Class<T> classOfT) {
		db.open(user, pass);

		for (ODocument objDoc : db.browseClass(classOfT.getSimpleName())) {
			T obj = new Gson().fromJson(objDoc.toJSON(), classOfT);
			obj.setDbId(objDoc.getIdentity().toString());
			objects.add(obj);
		}

		db.close();
	}

	public void save(T t) {
		db.open(user, pass);

		ODocument doc = db.getRecord(new ORecordId(t.getDbId()));
		doc.fromJSON(new Gson().toJson(t));
		doc.save();

		db.close();
	}

}
