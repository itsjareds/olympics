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
public class SaveButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = -6163448448443567531L;
	private final Mediator mediator;
	private final JPanel panel;

	/**
	 * Constructor for SaveButton.
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
	 * Method execute.
	 * @param arg0 ActionEvent @see edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface#execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.save(arg0, panel);
	}

}
