package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 * @author bbest
 * @version $Revision: 1.0 $
 */
public class UnregisterButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = 6543859565869791840L;
	private final Mediator mediator;
	private JPanel panel;

	/**
	 * Constructor for UnregisterButton.
	 * @param aL ActionListener
	 * @param mediator Mediator
	 * @param panel JPanel
	 */
	public UnregisterButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("Unregister");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerUnregister(this);
	}

	/**
	 * Method execute.
	 * @param arg0 ActionEvent @see edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface#execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.unregisterAthlete(arg0, panel);
	}
}
