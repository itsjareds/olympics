package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

/**
 */
public class SearchButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = 8988096125384043296L;
	private Mediator mediator;
	private JPanel panel;

	/**
	 * Constructor for SearchButton.
	 * @param aL MediatorActionListener
	 * @param mediator Mediator
	 * @param panel JPanel
	 */
	public SearchButton(MediatorActionListener aL, Mediator mediator,
			JPanel panel) {
		super("Search");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerSearch(this);
	}

	/**
	 * Method execute.
	 * @param arg0 ActionEvent
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface#execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.search(arg0, panel);
	}

}
