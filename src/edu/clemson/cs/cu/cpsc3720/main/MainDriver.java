package edu.clemson.cs.cu.cpsc3720.main;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.orientechnologies.common.io.OIOException;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DatabaseAccessObject;
import edu.clemson.cs.cu.cpsc3720.gui.AdminMainFrame;
import edu.clemson.cs.cu.cpsc3720.gui.SplashDlg;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

/**
 */
public class MainDriver {
	// owns a private static database object and mediator
	private static Mediator mediator;
	private static SplashDlg dialog;

	/**
	 * Method main.
	 * @param args String[]
	 */
	public static void main(String[] args) {

		MainDriver.mediator = new Mediator();

		try {
			dialog = new SplashDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			dialog.setProgress(0, "Loading Athletes...");
			DaoRepository.getAthletesDao().load();
			dialog.setProgress(1, "Loading Events...");
			DaoRepository.getEventsDao().load();
			dialog.setProgress(2, "Loading Heats...");
			DaoRepository.getHeatsDao().load();
			dialog.setProgress(3, "Loading Registrations...");
			DaoRepository.getRegistrationsDao().load();
			dialog.setProgress(4, "Loading Schools...");
			DaoRepository.getSchoolsDao().load();
			dialog.setProgress(5, "Loading Teachers...");
			DaoRepository.getTeachersDao().load();
			dialog.setProgress(6, "Initializing main interface...");
		} catch (OIOException e) {
			JOptionPane
					.showMessageDialog(null,
							"Failed to connect to database. Check your network connection.");
			dialog.dispose();
			quit(1);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Invalid database objects.");
			dialog.dispose();
			quit(1);
		}

		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AdminMainFrame frame = new AdminMainFrame(mediator);
					frame.setLocationRelativeTo(null);
					dialog.dispose();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void quit(int code) {
		ODatabaseDocumentTx db = DatabaseAccessObject.getDb();
		if (!db.isClosed())
			DatabaseAccessObject.getDb().close();

		System.exit(code);
	}
}
