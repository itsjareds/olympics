package edu.clemson.cs.cu.cpsc3720.mediator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import edu.clemson.cs.cu.cpsc3720.gui.AdminMainFrame;
import edu.clemson.cs.cu.cpsc3720.gui.LoginDlg;
import edu.clemson.cs.cu.cpsc3720.gui.TeacherDlg;
import edu.clemson.cs.cu.cpsc3720.gui.componets.CancelButton;
import edu.clemson.cs.cu.cpsc3720.gui.componets.LoginButton;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.MediatorInterface;

/**
 * <h1>Mediator</h1>
 * <p>
 * The Mediator class implements the MediatorInterface and executes the various
 * actions assigned to its respective button.
 * 
 * @author Darrell Best - bbest
 * @version 1.0
 * @since 2014-09-22
 */
public class Mediator implements MediatorInterface {

	private CancelButton cancelButton;
	private LoginButton loginButton;

	/**
	 * This method stores an instance of the static class
	 * {@link edu.clemson.cs.cu.cpsc3720.gui.componets.CancelButton
	 * CancelButton} so action can be executed.
	 * 
	 * @param cancelButton
	 */
	@Override
	public void registerCancel(CancelButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
	 * This method gives the cancel button functionality to close the selected
	 * window.
	 * 
	 * @param arg0
	 *            {@link java.awt.event.ActionEvent ActionEvent}
	 * @param dialog
	 *            - JDialog
	 */
	@Override
	public void cancel(ActionEvent arg0, JDialog dialog) {
		cancelButton.setEnabled(true);
		dialog.dispose();
	}

	public void registerLogin(LoginButton loginButton) {
		this.loginButton = loginButton;
	}

	public void login(ActionEvent arg0, String userName, String password,
			LoginDlg loginDlg) {
		loginButton.setEnabled(true);

		// authenticate user, if user type is admin then open admin main frame
		// if user is of type teacher, then open the teacher dlg

		loginDlg.dispose();

		if (userName.equals("Admin")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AdminMainFrame frame = new AdminMainFrame();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else if (userName.equals("Teacher")) {
			try {
				TeacherDlg dialog = new TeacherDlg();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
