package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Registration;

public class RegisterAthleteController {

	public void saveRegistration(Registration r) {
		DaoRepository.getRegistrationsDao().save(r);
	}

	public void deleteRegistration(Registration r) {
		DaoRepository.getRegistrationsDao().delete(r);
	}
}
