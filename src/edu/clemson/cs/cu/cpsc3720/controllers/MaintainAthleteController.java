package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.validators.AthleteValidator;
import edu.clemson.cs.cu.cpsc3720.validators.DatabaseObjectValidator.InvalidObjectException;

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
	 * @throws InvalidObjectException
	 */
	public void saveAthlete(Athlete a) throws InvalidObjectException {
		AthleteValidator validator = new AthleteValidator();

		if (validator.isValid(a)) {
			DaoRepository.getAthletesDao().save(a);
		}
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
