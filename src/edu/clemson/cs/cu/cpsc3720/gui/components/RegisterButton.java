package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 */
public class RegisterButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = -7299646163349628035L;
	private final Mediator mediator;
	private JPanel panel;

	/**
	 * Constructor for RegisterButton.
	 * @param aL ActionListener
	 * @param mediator Mediator
	 * @param panel JPanel
	 */
	public RegisterButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("Register");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerRegister(this);
	}

	/**
	 * Method execute.
	 * @param arg0 ActionEvent
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface#execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.newItem(arg0, panel);
	}
}
