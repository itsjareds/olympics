package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public interface DeletionSubject {
	/**
	 * Method registerDeletionObserver.
	 * @param observer DeletionObserver
	 */
	public void registerDeletionObserver(DeletionObserver observer);

	/**
	 * Method unregisterDeletionObserver.
	 * @param observer DeletionObserver
	 */
	public void unregisterDeletionObserver(DeletionObserver observer);

	public void notifyDelete();
}
