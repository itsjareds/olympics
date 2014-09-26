package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.ComandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class DeleteButton extends JButton implements ComandInterface {

	private static final long serialVersionUID = -6231899390514652352L;
	private Mediator mediator;

	public DeleteButton(MediatorActionListener aL, Mediator mediator) {
		super("Delete");
		this.mediator = mediator;
		this.addActionListener(aL);
		this.mediator.registerDelete(this);
	}

	@Override
	public void execute(ActionEvent arg0) {
		mediator.delete(arg0);
	}

}
