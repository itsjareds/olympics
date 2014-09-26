package edu.clemson.cs.cu.cpsc3720.main;

import java.awt.EventQueue;

import edu.clemson.cs.cu.cpsc3720.gui.AdminMainFrame;
import edu.clemson.cs.cu.cpsc3720.mediator.Mediator;

public class MainDriver {
	// owns a private static database object and mediator
	private static Mediator mediator;

	public static void main(String[] args) {

		MainDriver.mediator = new Mediator();

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
