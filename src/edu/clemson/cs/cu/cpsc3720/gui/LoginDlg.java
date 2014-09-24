package edu.clemson.cs.cu.cpsc3720.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.clemson.cs.cu.cpsc3720.gui.componets.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.componets.LoginButton;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;
import edu.clemson.cs.cu.cpsc3720.mediator.MediatorActionListener;

public class LoginDlg extends JDialog {

	private static final long serialVersionUID = 1569123077765500795L;
	private final JPanel contentPanel = new JPanel();
	private Mediator mediator;
	private JTextField userNameTextField;
	private JPasswordField passwordField;

	/**
	 * Create the login dialog.
	 * 
	 * @param mediator
	 */
	public LoginDlg(Mediator mediator) {
		setTitle("Login to T-J 1.0");
		this.mediator = mediator;
		setResizable(false);
		setBounds(100, 100, 329, 185);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 323, 121);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblUsername = new JLabel(" Username or Email");
		lblUsername.setBounds(6, 16, 131, 16);
		contentPanel.add(lblUsername);

		userNameTextField = new JTextField();
		userNameTextField.setBounds(6, 34, 311, 28);
		contentPanel.add(userNameTextField);
		userNameTextField.setColumns(10);

		JLabel lblPassword = new JLabel(" Password");
		lblPassword.setBounds(6, 69, 131, 16);
		contentPanel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(6, 87, 311, 28);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 119, 323, 43);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton loginButton = new LoginButton(
						new MediatorActionListener(), this.mediator, this);
				loginButton.setActionCommand("Login");
				buttonPane.add(loginButton);
				getRootPane().setDefaultButton(loginButton);
			}
			{
				JButton cancelButton = new CancelButton(
						new MediatorActionListener(), this.mediator, this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String getUserNameTextField() {
		return this.userNameTextField.getText().trim();
	}

	public String getPasswordField() {
		return String.valueOf(this.passwordField.getPassword()).trim();
	}
}
