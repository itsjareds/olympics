package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
 * <h1>Admin Panel Interface</h1>
 * <p>
 * Interface that allows for panels to be cleared on JTabbedPane selection
 * change.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public interface AdminPanelInterface {

	/**
	 * Method clearPanel.
	 * <p>
	 * This method may be called by an outsider to clear the panel contents.
	 */
	public void clearPanel();
}
