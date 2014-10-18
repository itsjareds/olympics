package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Registration;

/**
 */
public class RegisterAthleteController {

	/**
	 * Method saveRegistration.
	 * @param r Registration
	 */
	public boolean saveRegistration(Registration r) {
		boolean saved = false;
		System.out.println("Entered saveRegistration()");
		if (r.getAthleteRef() != null && r.getEventRef() != null) {
			System.out.println("Adding registration with Event="
					+ r.getEventRef());
			DaoRepository.getRegistrationsDao().save(r);
			saved = true;

			System.out.println("Updating registration references in Athlete="
					+ r.getAthleteRef());

			Athlete a = r.getAthlete();
			if (a.getRegRefs().indexOf(r.getDbId()) == -1) {
				a.getRegRefs().add(r.getDbId());
				DaoRepository.getAthletesDao().save(a);
			}
		} else
			System.out.println("Something went horribly, horribly wrong");
		return saved;
	}

	/**
	 * Method deleteRegistration.
	 * @param r Registration
	 */
	public Registration deleteRegistration(Registration r) {
		System.out.println("Deleting registration with @rid=" + r);
		r.getAthlete().getRegRefs().remove(r.getDbId());
		DaoRepository.getAthletesDao().save(r.getAthlete());
		return DaoRepository.getRegistrationsDao().delete(r);
	}
}
