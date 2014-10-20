package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
 * <h1>Deletion Subject</h1>
 * <p>
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
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
