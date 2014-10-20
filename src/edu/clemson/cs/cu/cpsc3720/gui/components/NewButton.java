package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 * <h1>New Button</h1>
 * <p>
 * JButton that holds a reference to the Mediator and calls its appropriate
 * execute funtion.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class NewButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = -5728398175248638254L;
	private final Mediator mediator;
	private JPanel panel;

	/**
	 * Instantiates a button called "New" and performs an new action.
	 * @param aL ActionListener
	 * @param mediator Mediator
	 * @param panel JPanel
	 */
	public NewButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("New");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerNew(this);
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
		mediator.newItem(arg0, panel);
	}

}
