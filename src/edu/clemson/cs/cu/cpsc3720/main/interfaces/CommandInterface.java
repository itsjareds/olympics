package edu.clemson.cs.cu.cpsc3720.main.interfaces;

import java.awt.event.ActionEvent;

/**
 * <h1>Command Interface</h1>
 * <p>
 * This interface is the base of all actions performed with the aid of buttons
 * or menu items.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public interface CommandInterface {

	/**
	 * Provides the action to a button.
	 * @param arg0 - String The name of the desired action.
	 */
	public void execute(ActionEvent arg0);

}
