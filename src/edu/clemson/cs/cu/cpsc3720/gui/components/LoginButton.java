package edu.clemson.cs.cu.cpsc3720.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.clemson.cs.cu.cpsc3720.gui.LoginDlg;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.ComandInterface;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class LoginButton extends JButton implements ComandInterface {

	private static final long serialVersionUID = 3310292294285405177L;
	private Mediator mediator;
	private LoginDlg loginDlg;

	public LoginButton(ActionListener aL, Mediator mediator, LoginDlg dialog) {
		super("Login");
		this.mediator = mediator;
		addActionListener(aL);
		this.mediator.registerLogin(this);
		this.loginDlg = dialog;
	}

	@Override
	public void execute(ActionEvent arg0) {
		String userName = loginDlg.getUserNameTextField();
		String password = loginDlg.getPasswordField();
		mediator.login(arg0, userName, password, loginDlg);
	}
}
