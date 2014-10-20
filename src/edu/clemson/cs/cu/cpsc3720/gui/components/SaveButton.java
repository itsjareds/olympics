package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 * <h1>Save Button</h1>
 * <p>
 * JButton that holds a reference to the Mediator and calls its appropriate
 * execute funtion.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class SaveButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = -6163448448443567531L;
	private final Mediator mediator;
	private final JPanel panel;

	/**
	 * Instantiates a button called "Save" and performs a save action.
	 * @param aL ActionListener
	 * @param mediator Mediator
	 * @param panel JPanel
	 */
	public SaveButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("Save");
		this.panel = panel;
		this.mediator = mediator;
		this.addActionListener(aL);
		this.mediator.registerSave(this);
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
		mediator.save(arg0, panel);
	}

}
