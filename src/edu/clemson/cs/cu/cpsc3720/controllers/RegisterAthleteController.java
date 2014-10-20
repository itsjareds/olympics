package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Registration;

/**
 * @author bbest
 * @version $Revision: 1.0 $
 */
public class RegisterAthleteController {

	/**
	 * Method saveRegistration.
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
	 * @param r Registration
	 * @return Registration
	 */
	public Registration deleteRegistration(Registration r) {
		r.notifyDelete();
		return DaoRepository.getRegistrationsDao().delete(r);
	}
}
