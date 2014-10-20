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
 * <h1>Main Driver</h1>
 * <p>
 * Main driver class that instantiates the main frame and loads data from the
 * database.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class MainDriver {
	// owns a private static database object and mediator
	private static Mediator mediator;
	private static SplashDlg dialog;

	/**
	 * Main method
	 * @param args String[]
	 */
	public static void main(String[] args) {

		MainDriver.mediator = new Mediator();

		final int MAX_PROGRESS = 8;

		try {
			dialog = new SplashDlg(MAX_PROGRESS);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			quit(1);
		}

		try {
			int progress = -1;
			dialog.setProgress(++progress, "Verifying schema...");
			DaoRepository.initialize();
			dialog.setProgress(++progress, "Loading Athletes...");
			DaoRepository.getAthletesDao().load();
			dialog.setProgress(++progress, "Loading Events...");
			DaoRepository.getEventsDao().load();
			dialog.setProgress(++progress, "Loading Heats...");
			DaoRepository.getHeatsDao().load();
			dialog.setProgress(++progress, "Loading Registrations...");
			DaoRepository.getRegistrationsDao().load();
			dialog.setProgress(++progress, "Loading Schools...");
			DaoRepository.getSchoolsDao().load();
			dialog.setProgress(++progress, "Loading Teachers...");
			DaoRepository.getTeachersDao().load();
			dialog.setProgress(++progress, "Executing database hooks...");
			DaoRepository.runHooks();
			dialog.setProgress(++progress, "Initializing main interface...");
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

	/**
	 * Method quit exists the system. This is called if there is an OIOException
	 * or IllegalArgumentException.
	 * @param code int
	 */
	public static void quit(int code) {
		ODatabaseDocumentTx db = DatabaseAccessObject.getDb();
		if (!db.isClosed())
			DatabaseAccessObject.getDb().close();

		System.exit(code);
	}
}
