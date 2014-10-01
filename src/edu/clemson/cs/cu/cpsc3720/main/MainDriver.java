package edu.clemson.cs.cu.cpsc3720.main;

import java.awt.EventQueue;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.gui.AdminMainFrame;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class MainDriver {
	// owns a private static database object and mediator
	private static Mediator mediator;

	public static void main(String[] args) {

		MainDriver.mediator = new Mediator();

		try {
			DaoRepository.getAthletes().load(Athlete.class);
			DaoRepository.getEvents().load(Event.class);
			DaoRepository.getHeats().load(Heat.class);
			DaoRepository.getRegistrations().load(Registration.class);
			DaoRepository.getSchools().load(School.class);
			DaoRepository.getTeachers().load(Teacher.class);
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
	}

}
