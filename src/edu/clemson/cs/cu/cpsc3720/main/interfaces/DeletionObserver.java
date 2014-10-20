package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
 * @author bbest
 * @version $Revision: 1.0 $
 */
public interface DeletionObserver {
	/**
	 * Method deleteReference.
	 * @param subject DeletionSubject
	 */
	public void deleteReference(DeletionSubject subject);

	public void runHooks();
}
