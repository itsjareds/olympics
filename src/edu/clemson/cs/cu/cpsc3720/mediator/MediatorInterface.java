package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import edu.clemson.cs.cu.cpsc3720.gui.LoginDlg;
import edu.clemson.cs.cu.cpsc3720.gui.componets.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.componets.LoginButton;

/**
 * <h1>Mediator Interface</h1>
 * <p>
 * This interface is the base of the mediator pattern that provides
 * functionality to buttons.
 * 
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public interface MediatorInterface {

	/**
	 * This method is intended to
	 * 
	 * @param arg0
	 *            - {@link java.awt.event.ActionEvent Action Event}
	 */
	public void registerCancel(CancelButton cancelButton);

	public void registerLogin(LoginButton loginButton);

	public void cancel(ActionEvent arg0, JDialog dialog);

	public void login(ActionEvent arg0, String userName, String password,
			LoginDlg loginDlg);
}
