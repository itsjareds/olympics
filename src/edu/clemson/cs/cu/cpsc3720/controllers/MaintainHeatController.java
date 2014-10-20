package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Heat;

/**
 * @author bbest
 * @version $Revision: 1.0 $
 */
public class MaintainHeatController {

	/**
	 * Method addHeat.
	 * @param h Heat @return boolean
	 */
	public boolean addHeat(Heat h) {
		boolean added = false;
		if (h.getEventRef() != null) {
			DaoRepository.getHeatsDao().save(h);
			added = true;
		}
		return added;
	}

	/**
	 * Method removeHeat.
	 * @param h Heat @return Heat
	 */
	public Heat removeHeat(Heat h) {
		h.notifyDelete();
		return DaoRepository.getHeatsDao().delete(h);
	}

}
