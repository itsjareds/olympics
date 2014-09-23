package edu.clemson.cs.cu.cpsc3720.gui.componets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import edu.clemson.cs.cu.cpsc3720.mediator.ComandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class CancelButton extends JButton implements ComandInterface {

	private static final long serialVersionUID = 4810322146053818837L;
	private final Mediator mediator;
	private final JDialog dialog;

	/**
	 * Instantiates a button called "Cancel" and gives it the action to close a
	 * window.
	 * 
	 * @param aL
	 *            - ActionListerner for the button
	 * @param mediator
	 *            - a instance of the mediator
	 * @param dialog
	 *            - a instance of the window being used
	 */
	public CancelButton(ActionListener aL, Mediator mediator, JDialog dialog) {
		super("Cancel");
		this.mediator = mediator;
		this.dialog = dialog;
		addActionListener(aL);
		this.mediator.registerCancel(this);
	}

	/**
	 * Executes the intended method specified by the
	 * {@link edu.clemson.cs.cu.cpsc3720.mediator.Mediator} class.
	 * 
	 * @param - ActionEvent {@link java.awt.event.ActionEvent Action Event}
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.cancel(arg0, dialog);
	}

}
