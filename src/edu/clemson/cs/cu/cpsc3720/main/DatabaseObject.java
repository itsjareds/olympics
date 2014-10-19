package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

public abstract class DatabaseObject implements DatabaseSerializable,
		DeletionSubject, DeletionObserver {

	private transient String dbId;
	private ArrayList<DeletionObserver> deletionObservers;

	{
		deletionObservers = new ArrayList<DeletionObserver>();
	}

	public String getDbId() {
		return this.dbId;
	}

	public void setDbId(String id) {
		this.dbId = id;
	}

	public void registerDeletionObserver(DeletionObserver observer) {
		boolean found = false;
		for (DeletionObserver registered : deletionObservers) {
			if (registered.equals(observer)) {
				found = true;
				break;
			}
		}
		if (!found)
			deletionObservers.add(observer);
	}

	public void notifyDelete() {
		for (DeletionObserver observer : deletionObservers)
			observer.deleteReference(this);
	}

}