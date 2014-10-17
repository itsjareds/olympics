package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;

/**
 */
public class MaintainAthleteController {

	/**
	 * Method saveAthlete.
	 * @param athlete Athlete
	 */
	public void saveAthlete(Athlete athlete) {
		DaoRepository.getAthletesDao().save(athlete);
	}

	/**
	 * Method deleteAthlete.
	 * @param athlete Athlete
	 */
	public void deleteAthlete(Athlete athlete) {
		DaoRepository.getAthletesDao().delete(athlete);
	}

}
