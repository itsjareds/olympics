package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;

public class MaintainAthleteController {

	public void saveAthlete(Athlete athlete) {
		DaoRepository.getAthletesDao().save(athlete);
	}

	public void deleteAthlete(Athlete athlete) {
		DaoRepository.getAthletesDao().delete(athlete);
	}

}
