package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

public abstract class DatabaseObject implements DatabaseSerializable,
		DeletionSubject, DeletionObserver {

	private transient String dbId;

	public String getDbId() {
		return this.dbId;
	}

	public void setDbId(String id) {
		this.dbId = id;
	}

	public void notifyDelete() {

	}

}