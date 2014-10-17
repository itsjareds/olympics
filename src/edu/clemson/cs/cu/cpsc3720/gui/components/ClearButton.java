package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class ClearButton extends JButton implements CommandInterface {

	private final Mediator mediator;
	private final JPanel panel;

	/**
	 * Instantiates a button called "Clear" and performs a clear action.
	 * 
	 * @param aL
	 *            - ActionListerner for the button
	 * @param mediator
	 *            - a instance of the mediator
	 * @param dialog
	 *            - a instance of the panel being used
	 */
	public ClearButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("Clear");
		this.mediator = mediator;
		this.panel = panel;
		addActionListener(aL);
		this.mediator.registerClear(this);
	}

	/**
	 * Executes the intended method specified by the
	 * {@link edu.clemson.cs.cu.cpsc3720.mediator.Mediator} class.
	 * 
	 * @param - ActionEvent {@link java.awt.event.ActionEvent Action Event}
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.clear(arg0, panel);
	}

}
