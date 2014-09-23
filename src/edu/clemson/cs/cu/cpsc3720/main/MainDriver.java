package edu.clemson.cs.cu.cpsc3720.main;

import javax.swing.JDialog;

import edu.clemson.cs.cu.cpsc3720.gui.LoginDlg;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class MainDriver {
	// owns a private static database object and mediator
	private static Mediator mediator;

	public static void main(String[] args) {

		MainDriver.mediator = new Mediator();

		/**
		 * Launch the application.
		 */
		try {
			LoginDlg dialog = new LoginDlg(mediator);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
