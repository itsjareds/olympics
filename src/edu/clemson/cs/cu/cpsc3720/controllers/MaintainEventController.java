package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Event;

/**
 */
public class MaintainEventController {

	/**
	 * Method saveEvent.
	 * @param e Event
	 */
	public void saveEvent(Event e) {
		DaoRepository.getEventsDao().save(e);
	}

	/**
	 * Method deleteEvent.
	 * @param event Event
	 * @return Event
	 */
	public Event deleteEvent(Event event) {
		event.notifyDelete();
		return DaoRepository.getEventsDao().delete(event);
	}

}
