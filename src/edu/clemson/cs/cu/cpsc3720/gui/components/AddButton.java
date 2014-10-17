package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 */
public class AddButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = 3932286544230936861L;
	private final Mediator mediator;
	private final JPanel panel;

	/**
	 * Instantiates a button called "Add" and performs an add action.
	 * 
	 * @param aL
	 *            - ActionListerner for the button
	 * @param mediator
	 *            - a instance of the mediator
	
	 * @param panel JPanel
	 */
	public AddButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("Add");
		this.mediator = mediator;
		this.panel = panel;
		addActionListener(aL);
		this.mediator.registerAdd(this);
	}

	/**
	 * Executes the intended method specified by the
	 * {@link edu.clemson.cs.cu.cpsc3720.mediator.Mediator} class.
	 * 
	
	 * @param arg0 ActionEvent
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface#execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.add(arg0, panel);
	}

}
