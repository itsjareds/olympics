package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * <h1>Database Object</h1>
 * <p>
 * Observer pattern class to implement cascading deletion in the database.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
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
	@Override
	public void initialize() {
		if (deletionObservers == null)
			deletionObservers = new ArrayList<DeletionObserver>();
	}

	/**
	 * Method getDbId.
	 * @return String
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable
	 *      #getDbId()
	 */
	@Override
	public String getDbId() {
		return this.dbId;
	}

	/**
	 * Method setDbId.
	 * @param id String @see
	 *            edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable
	 *            #setDbId(String)
	 */
	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

	/**
	 * Method registerDeletionObserver.
	 * @param observer DeletionObserver @see
	 *            edu.clemson.cs.cu.cpsc3720.main.interfaces
	 *            .DeletionSubject#registerDeletionObserver(DeletionObserver)
	 */
	@Override
	public void registerDeletionObserver(DeletionObserver observer) {
		if (!deletionObservers.contains(observer))
			deletionObservers.add(observer);
	}

	/**
	 * Method unregisterDeletionObserver.
	 * @param observer DeletionObserver @see
	 *            edu.clemson.cs.cu.cpsc3720.main.interfaces
	 *            .DeletionSubject#unregisterDeletionObserver(DeletionObserver)
	 */
	@Override
	public void unregisterDeletionObserver(DeletionObserver observer) {
		deletionObservers.remove(observer);
	}

	/**
	 * Method notifyDelete.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject#notifyDelete()
	 */
	@Override
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
	@Override
	public void runHooks() {

	}

}