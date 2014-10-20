package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;

/**
 * <h1>Maintain Athlete Controller</h1>
 * <p>
 * Handles creation, saving, deleting, and updating of an athlete in the
 * database. Called by the Mediator.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class MaintainAthleteController {

	/**
	 * Method saveAthlete.
	 * <p>
	 * Creates, updates, and saves an Athlete in the database.
	 * @param athlete Athlete
	 */
	public void saveAthlete(Athlete athlete) {
		DaoRepository.getAthletesDao().save(athlete);
	}

	/**
	 * Method deleteAthlete.
	 * <p>
	 * Deletes an Athlete from the database.
	 * @param athlete Athlete
	 * @return Athlete
	 */
	public Athlete deleteAthlete(Athlete athlete) {
		athlete.notifyDelete();
		return DaoRepository.getAthletesDao().delete(athlete);
	}

}
