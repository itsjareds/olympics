package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

/**
 * <h1>Search Button</h1>
 * <p>
 * JButton that holds a reference to the Mediator and calls its appropriate
 * execute funtion.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class SearchButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = 8988096125384043296L;
	private Mediator mediator;
	private JPanel panel;

	/**
	 * Instantiates a button called "Search" and performs a search action.
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
	 * Executes the intended method specified by the
	 * {@link edu.clemson.cs.cu.cpsc3720.mediator.Mediator} class.
	 * @param arg0 ActionEvent @see
	 *            edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface
	 *            #execute(ActionEvent)
	 */
	@Override
	public void execute(ActionEvent arg0) {
		mediator.search(arg0, panel);
	}

}
