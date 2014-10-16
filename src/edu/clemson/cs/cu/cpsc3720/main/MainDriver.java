package edu.clemson.cs.cu.cpsc3720.main;

import java.awt.EventQueue;

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
			DaoRepository.getAthletesDao().load(Athlete.class);
			DaoRepository.getEventsDao().load(Event.class);
			DaoRepository.getHeatsDao().load(Heat.class);
			DaoRepository.getRegistrationsDao().load(Registration.class);
			DaoRepository.getSchoolsDao().load(School.class);
			DaoRepository.getTeachersDao().load(Teacher.class);
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
