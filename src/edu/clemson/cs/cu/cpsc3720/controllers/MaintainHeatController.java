package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Heat;

/**
 * <h1>Maintain Heat Controller</h1>
 * <p>
 * Handles creation, saving, deleting, and updating of a Heat in the database.
 * Called by the mediator.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class MaintainHeatController {

	/**
	 * Method addHeat.
	 * <p>
	 * Creates, updates, and saves a Heat in the database.
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
	 * <p>
	 * Deletes a Heat in the database.
	 * @param h Heat @return Heat
	 */
	public Heat removeHeat(Heat h) {
		h.notifyDelete();
		return DaoRepository.getHeatsDao().delete(h);
	}

}
