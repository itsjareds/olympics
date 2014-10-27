package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Heat;
import edu.clemson.cs.cu.cpsc3720.validators.DatabaseObjectValidator.InvalidObjectException;
import edu.clemson.cs.cu.cpsc3720.validators.HeatValidator;

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
	public void addHeat(Heat h) throws InvalidObjectException {
		HeatValidator validator = new HeatValidator();
		if (validator.isValid(h))
			DaoRepository.getHeatsDao().save(h);
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
