package edu.clemson.cs.cu.cpsc3720.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import com.orientechnologies.common.io.OIOException;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DatabaseAccessObject;
import edu.clemson.cs.cu.cpsc3720.gui.AdminMainFrame;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class MainDriver {
	// owns a private static database object and mediator
	private static Mediator mediator;

	public static void main(String[] args) {

		MainDriver.mediator = new Mediator();

		try {
			DaoRepository.getAthletesDao().load();
			DaoRepository.getEventsDao().load();
			DaoRepository.getHeatsDao().load();
			DaoRepository.getRegistrationsDao().load();
			DaoRepository.getSchoolsDao().load();
			DaoRepository.getTeachersDao().load();
		} catch (OIOException e) {
			JOptionPane
					.showMessageDialog(null,
							"Failed to connect to database. Check your network connection.");
		} catch (IllegalArgumentException e) {
			// classes not in database, do not load
		}

		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrame frame = new AdminMainFrame(mediator);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ODatabaseDocumentTx db = DatabaseAccessObject.getDb();
		if (!db.isClosed())
			DatabaseAccessObject.getDb().close();
	}
}
