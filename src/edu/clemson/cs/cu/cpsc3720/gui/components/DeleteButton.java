package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class DeleteButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = -6231899390514652352L;
	private Mediator mediator;
	private JPanel panel;

	public DeleteButton(MediatorActionListener aL, Mediator mediator,
			JPanel panel) {
		super("Delete");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerDelete(this);
	}

	@Override
	public void execute(ActionEvent arg0) {
		mediator.delete(arg0, panel);
	}

}
