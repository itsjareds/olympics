package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Registration;

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
	 */
	public boolean saveRegistration(Registration r) {
		boolean saved = false;
		if (r.getAthleteRef() != null && r.getEventRef() != null) {
			DaoRepository.getRegistrationsDao().save(r);
			saved = true;

			Athlete a = r.getAthlete();
			a.addRegRef(r.getDbId());
			DaoRepository.getAthletesDao().save(a);
		}
		return saved;
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
