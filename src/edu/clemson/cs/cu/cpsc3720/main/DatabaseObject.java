package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * @author bbest
 * @version $Revision: 1.0 $
 */
public abstract class DatabaseObject implements DatabaseSerializable,
		DeletionSubject, DeletionObserver {

	private transient String dbId;
	private transient ArrayList<DeletionObserver> deletionObservers;

	{
		initialize();
	}

	/**
	 * Method initialize.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#initialize()
	 */
	public void initialize() {
		if (deletionObservers == null)
			deletionObservers = new ArrayList<DeletionObserver>();
	}

	/**
	 * Method getDbId. @return String * @see
	 *         edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable
	 *         #getDbId()
	 */
	public String getDbId() {
		return this.dbId;
	}

	/**
	 * Method setDbId.
	 * @param id String @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#setDbId(String)
	 */
	public void setDbId(String id) {
		this.dbId = id;
	}

	/**
	 * Method registerDeletionObserver.
	 * @param observer DeletionObserver @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject#registerDeletionObserver(DeletionObserver)
	 */
	public void registerDeletionObserver(DeletionObserver observer) {
		if (!deletionObservers.contains(observer))
			deletionObservers.add(observer);
	}

	/**
	 * Method unregisterDeletionObserver.
	 * @param observer DeletionObserver @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject#unregisterDeletionObserver(DeletionObserver)
	 */
	public void unregisterDeletionObserver(DeletionObserver observer) {
		deletionObservers.remove(observer);
	}

	/**
	 * Method notifyDelete.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject#notifyDelete()
	 */
	public void notifyDelete() {
		ArrayList<DeletionObserver> observers = new ArrayList<DeletionObserver>();
		observers.addAll(deletionObservers);
		for (DeletionObserver observer : observers) {
			System.out.println(this + " notifying observer " + observer);
			observer.deleteReference(this);
		}

		deletionObservers.clear();
	}

	/*
	 * deleteReference(DeletionSubject subject) not implemented so that
	 * extending classes are forced to implement the method.
	 */

	/**
	 * Method runHooks.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver#runHooks()
	 */
	public void runHooks() {

	}

}