package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.CommandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class NewButton extends JButton implements CommandInterface {

	private static final long serialVersionUID = -5728398175248638254L;
	private final Mediator mediator;
	private JPanel panel;

	public NewButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("New");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerNew(this);
	}

	@Override
	public void execute(ActionEvent arg0) {
		mediator.newItem(arg0, panel);
	}

}
