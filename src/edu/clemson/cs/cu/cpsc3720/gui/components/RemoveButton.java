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
public class RemoveButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = 7977707859821379410L;
	private final Mediator mediator;
	private final JPanel panel;

	/**
	 * Instantiates a button called "Remove" and performs a remove action.
	 * @param aL - ActionListener for the button
	 * @param mediator - a instance of the mediator
	 * @param panel - a instance of the panel being used
	 */
	public RemoveButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("Remove");
		this.mediator = mediator;
		this.panel = panel;
		addActionListener(aL);
		this.mediator.registerRemove(this);
	}

	/**
	 * Executes the intended method specified by the
	 * {@link edu.clemson.cs.cu.cpsc3720.mediator.Mediator} class.
	 * @param arg0 ActionEvent @see edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface#execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.remove(arg0, panel);
	}

}
