package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
 * <h1>Deletion Observer</h1>
 * <p>
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public interface DeletionObserver {
	/**
	 * Method deleteReference.
	 * @param subject DeletionSubject
	 */
	public void deleteReference(DeletionSubject subject);

	public void runHooks();
}
