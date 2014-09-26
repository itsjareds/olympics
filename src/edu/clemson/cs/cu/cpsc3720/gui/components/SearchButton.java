package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.ComandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class SearchButton extends JButton implements ComandInterface {

	private static final long serialVersionUID = 8988096125384043296L;
	private Mediator mediator;

	public SearchButton(MediatorActionListener aL, Mediator mediator) {
		super("Search");
		this.mediator = mediator;
		this.addActionListener(aL);
		this.mediator.registerSearch(this);
	}

	@Override
	public void execute(ActionEvent arg0) {
		mediator.search(arg0);
	}

}
