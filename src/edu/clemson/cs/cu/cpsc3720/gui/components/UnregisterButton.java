package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 * <h1>Unregister Button</h1>
 * <p>
 * JButton that holds a reference to the Mediator and calls its appropriate
 * execute funtion.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class UnregisterButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = 6543859565869791840L;
	private final Mediator mediator;
	private JPanel panel;

	/**
	 * Instantiates a button called "Unregister" and performs an unregister
	 * action.
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
	 * Executes the intended method specified by the
	 * {@link edu.clemson.cs.cu.cpsc3720.mediator.Mediator} class.
	 * @param arg0 ActionEvent @see
	 *            edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface
	 *            #execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.unregisterAthlete(arg0, panel);
	}
}
