package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentPool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.record.impl.ODocument;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

/**
 * <h1>Database Access Object</h1>
 * <p>
 * Template class that extends the DatabaseSerializable class. Holds a list of
 * objects loaded from the database referenced by ClassOfT.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class DatabaseAccessObject<T extends DatabaseSerializable> {
	public final ArrayList<T> objects = new ArrayList<T>();
	private static String user = "root";
	private static String pass = "passw0rd";
	private final Class<T> classOfT;

	/**
	 * Constructor for DatabaseAccessObject.
	 * @param classOfT Class<T>
	 */
	public DatabaseAccessObject(Class<T> classOfT) {
		this.classOfT = classOfT;
	}

	/**
	 * Method getDb. @return ODatabaseDocumentTx
	 */
	public static ODatabaseDocumentTx getDb() {
		return ODatabaseDocumentPool.global().acquire(
				"remote:localhost:2424/BugSquasher", user, pass);
	}

	/**
	 * Method searchCache.
	 * @param ref String @return T
	 */
	public T searchCache(String ref) {
		T ret = null;
		for (T t : objects) {
			if (t.getDbId().equals(ref)) {
				ret = t;
				break;
			}
		}
		return ret;
	}

	/**
	 * Method delete.
	 * @param ref String @return T
	 */
	public T delete(String ref) {
		T ret = null;
		if (ref != null) {
			ODatabaseDocumentTx db = getDb();
			T cached = searchCache(ref);
			if (cached != null)
				objects.remove(cached);

			ODocument doc = db.getRecord(new ORecordId(ref));
			if (doc != null) {
				T dbObject = new Gson().fromJson(doc.toJSON(), classOfT);
				dbObject.initialize();
				dbObject.setDbId(doc.getIdentity().toString());
				if (doc != null) {
					db.delete(doc);
					ret = dbObject;
				}
			}

			db.close();
		}
		return ret;
	}

	/**
	 * Method delete.
	 * @param t T @return T
	 */
	public T delete(T t) {
		T ret = null;
		if (t != null && t.getDbId() != null)
			ret = delete(t.getDbId());
		return ret;
	}

	/**
	 * Method query.
	 * @param ref String @return T
	 */
	public T query(String ref) {
		T ret = null;

		/* Search local cache first */
		ret = searchCache(ref);

		if (ret == null) {
			ODatabaseDocumentTx db = getDb();

			if (db.getMetadata().getSchema()
					.existsClass(classOfT.getSimpleName())) {
				for (ODocument doc : db.browseClass(classOfT.getSimpleName())) {
					T t = new Gson().fromJson(doc.toJSON(), classOfT);
					t.initialize();
					t.setDbId(doc.getIdentity().toString());
					if (t.getDbId().equals(ref)) {
						ret = t;
						objects.add(t);
						break;
					}
				}
			}

			db.close();
		}

		return ret;
	}

	public void load() {
		ODatabaseDocumentTx db = getDb();

		for (ODocument objDoc : db.browseClass(classOfT.getSimpleName())) {
			T obj = new Gson().fromJson(objDoc.toJSON(), classOfT);
			obj.initialize();
			obj.setDbId(objDoc.getIdentity().toString());
			objects.add(obj);
		}

		db.close();
	}

	/**
	 * Method save.
	 * @param t T
	 */
	public void save(T t) {
		ODatabaseDocumentTx db = getDb();

		if (t != null) {
			ODocument doc = new ODocument(t.getClass().getSimpleName());
			if (t.getDbId() != null
					&& db.getRecord(new ORecordId(t.getDbId())) != null)
				doc = db.getRecord(new ORecordId(t.getDbId()));
			String json = new Gson().toJson(t);
			doc.fromJSON(json);
			t.setDbId(doc.save().getIdentity().toString());

			/* Add to local cache */
			T cached = searchCache(t.getDbId());
			if (cached == null)
				objects.add(t);
		}

		db.close();
	}
}
