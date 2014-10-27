package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.validators.DatabaseObjectValidator.InvalidObjectException;
import edu.clemson.cs.cu.cpsc3720.validators.RegistrationValidator;

/**
 * <h1>Register Athlete Controller</h1>
 * <p>
 * Handles creation, saving, deleting, and updating of a Registration in the
 * database. Called by the mediator.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class RegisterAthleteController {

	/**
	 * Method saveRegistration.
	 * <p>
	 * Creates, updates, and saves a Registration in the database.
	 * @param r Registration
	 * @return boolean
	 * @throws InvalidObjectException
	 */
	public void saveRegistration(Registration r) throws InvalidObjectException {
		RegistrationValidator validator = new RegistrationValidator();

		if (validator.isValid(r)) {
			DaoRepository.getRegistrationsDao().save(r);
			Athlete a = r.getAthlete();
			a.addRegRef(r.getDbId());
			// update the athlete
			DaoRepository.getAthletesDao().save(a);
		}
	}

	/**
	 * Method deleteRegistration.
	 * <p>
	 * Deletes a Registration in the database.
	 * @param r Registration
	 * @return Registration
	 */
	public Registration deleteRegistration(Registration r) {
		r.notifyDelete();
		return DaoRepository.getRegistrationsDao().delete(r);
	}
}
