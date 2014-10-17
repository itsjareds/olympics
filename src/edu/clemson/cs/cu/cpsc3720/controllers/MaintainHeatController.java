package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Heat;

public class MaintainHeatController {

	public boolean addHeat(Heat h) {
		boolean added = false;
		if (h.getEventRef() != null) {
			System.out.println("Adding heat with Event=" + h.getEvent());
			DaoRepository.getHeatsDao().save(h);
			added = true;
		}
		return added;
	}

	public Heat removeHeat(Heat h) {
		System.out.println("Removing heat with @rid=" + h.getDbId());
		return DaoRepository.getHeatsDao().delete(h);
	}

}
