package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Heat;

public class MaintainHeatController {

	public void addHeat(Heat h) {
		System.out.println("Adding heat with Event=" + h.getEvent());
		DaoRepository.getHeatsDao().save(h);
	}

	public Heat removeHeat(Heat h) {
		System.out.println("Removing heat with @rid=" + h.getDbId());
		return DaoRepository.getHeatsDao().delete(h);
	}
}
