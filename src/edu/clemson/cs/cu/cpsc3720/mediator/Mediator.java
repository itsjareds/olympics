package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;

import edu.clemson.cs.cu.cpsc3720.gui.componets.CancelButton;

/**
 * <h1>Mediator</h1>
 * <p>
 * The Mediator class implements the MediatorInterface and executes the various
 * actions assigned to its respective button.
 * 
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public class Mediator implements MediatorInterface {

	// private static database object
	private CancelButton cancelButton;

	/**
	 * This method stores an instance of the static class
	 * {@link edu.clemson.cu.cpsc215.bbest_bhglove_bcdoher.gui.componets.AboutMenuItem
	 * AboutMenuItem} so action can be executed.
	 * 
	 * @param aboutMenuItem
	 *            -
	 *            {@link edu.clemson.cu.cpsc215.bbest_bhglove_bcdoher.gui.componets.AboutMenuItem
	 *            AboutMenuItem}
	 */
	@Override
	public void registerCancel(CancelButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
	 * 
	 * @param arg0
	 *            - {@link java.awt.event.ActionEvent ActionEvent}
	 */
	@Override
	public void cancel(ActionEvent arg0) {
		// cancel and go back
	}

}
