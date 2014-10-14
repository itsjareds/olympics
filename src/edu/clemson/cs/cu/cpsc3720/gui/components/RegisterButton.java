package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.ComandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class RegisterButton extends JButton implements ComandInterface {

	private final Mediator mediator;
	private JPanel panel;

	public RegisterButton(ActionListener aL, Mediator mediator, JPanel panel) {
		super("New");
		this.mediator = mediator;
		this.panel = panel;
		this.addActionListener(aL);
		this.mediator.registerRegister(this);
	}

	@Override
	public void execute(ActionEvent arg0) {
		mediator.newItem(arg0, panel);
	}
}
