package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Registration;

/**
 */
public class RegisterAthleteController {

	/**
	 * Method saveRegistration.
	 * @param r Registration
	 */
	public void saveRegistration(Registration r) {
		DaoRepository.getRegistrationsDao().save(r);
	}

	/**
	 * Method deleteRegistration.
	 * @param r Registration
	 */
	public void deleteRegistration(Registration r) {
		DaoRepository.getRegistrationsDao().delete(r);
	}
}
