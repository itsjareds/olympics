package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Event;

/**
 * <h1>Maintain Event Controller</h1>
 * <p>
 * Handles creation, saving, deleting, and updating of an Event in the database.
 * Called by the mediator.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class MaintainEventController {

	/**
	 * Method saveEvent.
	 * <p>
	 * Creates, updates, and saves an Event in the database.
	 * @param e Event
	 */
	public void saveEvent(Event e) {
		DaoRepository.getEventsDao().save(e);
	}

	/**
	 * Method deleteEvent.
	 * <p>
	 * Deletes an Event in the database.
	 * @param event Event @return Event
	 */
	public Event deleteEvent(Event event) {
		event.notifyDelete();
		return DaoRepository.getEventsDao().delete(event);
	}

}
