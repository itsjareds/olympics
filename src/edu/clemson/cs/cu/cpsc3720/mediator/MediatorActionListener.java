package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;

/**
 * <h1>Mediator Action Listener</h1>
 * <p>
 * This class implements the action listener class, grabs the instance of the
 * command and performs the intended action.
 * @author bbest
 * @author shiz
 * @author klinge2
 */
public class MediatorActionListener implements ActionListener {
	/**
	 * This method assigns a command and then executes the intended action for
	 * the button or menu item.
	 * @param arg0 ActionEvent @see
	 *            java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CommandInterface command = (CommandInterface) arg0.getSource();
		command.execute(arg0);
	}
}
