package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.ComandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class NewButton extends JButton implements ComandInterface {

	private static final long serialVersionUID = -5728398175248638254L;
	private final Mediator mediator;

	public NewButton(ActionListener aL, Mediator mediator) {
		this.mediator = mediator;
		this.addActionListener(aL);
		this.mediator.registerNew(this);
	}

	@Override
	public void execute(ActionEvent arg0) {
		mediator.newItem(arg0);
	}

}
