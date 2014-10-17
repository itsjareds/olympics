package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;

/**
 * <h1>Mediator Action Listener</h1>
 * <p>
 * This class implements the action listener class, grabs the instance of the
 * command and performs the intended action.
 * 
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public class MediatorActionListener implements ActionListener {
	/**
	 * This method assigns a command and then executes the intended action for
	 * the button or menu item.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		CommandInterface command = (CommandInterface) arg0.getSource();
		command.execute(arg0);
	}
}
