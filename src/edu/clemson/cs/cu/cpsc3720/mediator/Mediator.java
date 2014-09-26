package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import edu.clemson.cs.cu.cpsc3720.gui.components.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.components.NewButton;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface;

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

	private CancelButton cancelButton;
	private NewButton newButton;

	/**
	 * This method stores an instance of the static class
	 * {@link edu.clemson.cs.cu.cpsc3720.gui.components.CancelButton
	 * CancelButton} so action can be executed.
	 * 
	 * @param cancelButton
	 */
	@Override
	public void registerCancel(CancelButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
	 * This method gives the cancel button functionality to close the selected
	 * window.
	 * 
	 * @param arg0
	 *            {@link java.awt.event.ActionEvent ActionEvent}
	 * @param dialog
	 *            - JDialog
	 */
	@Override
	public void cancel(ActionEvent arg0, JDialog dialog) {
		cancelButton.setEnabled(true);
		dialog.dispose();
	}

	@Override
	public void registerNew(NewButton newButton) {
		this.newButton = newButton;
	}

	@Override
	public void newItem(ActionEvent arg0) {
		this.newButton.setEnabled(true);
	}

}
