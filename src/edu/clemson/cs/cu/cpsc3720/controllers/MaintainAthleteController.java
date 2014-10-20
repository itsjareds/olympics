package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;

/**
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
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
	 * @return Athlete
	 */
	public Athlete deleteAthlete(Athlete athlete) {
		athlete.notifyDelete();
		return DaoRepository.getAthletesDao().delete(athlete);
	}

}
