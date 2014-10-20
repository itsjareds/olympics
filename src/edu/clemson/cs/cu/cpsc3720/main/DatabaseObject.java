package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

public abstract class DatabaseObject implements DatabaseSerializable,
		DeletionSubject, DeletionObserver {

	private transient String dbId;
	private transient ArrayList<DeletionObserver> deletionObservers;

	{
		initialize();
	}

	public void initialize() {
		if (deletionObservers == null)
			deletionObservers = new ArrayList<DeletionObserver>();
	}

	public String getDbId() {
		return this.dbId;
	}

	public void setDbId(String id) {
		this.dbId = id;
	}

	public void registerDeletionObserver(DeletionObserver observer) {
		if (!deletionObservers.contains(observer))
			deletionObservers.add(observer);
	}

	public void unregisterDeletionObserver(DeletionObserver observer) {
		deletionObservers.remove(observer);
	}

	public void notifyDelete() {
		ArrayList<DeletionObserver> observers = new ArrayList<DeletionObserver>();
		observers.addAll(deletionObservers);
		for (DeletionObserver observer : observers) {
			System.out.println("Notifying observer " + observer);
			observer.deleteReference(this);
		}

		/* List must be reloaded because observers may also have been deleted */
		deletionObservers.clear();
		for (DeletionObserver observer : observers) {
			deletionObservers.add(observer);
		}
	}

	/*
	 * deleteReference(DeletionSubject subject) not implemented so that
	 * extending classes are forced to implement the method.
	 */

}