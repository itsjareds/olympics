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
		System.out.println("Saving event " + e);
		DaoRepository.getEventsDao().save(e);
	}

	/**
	 * Method deleteEvent.
	 * @param e Event
	 * @return Event
	 */
	public Event deleteEvent(Event e) {
		System.out.println("Deleting event " + e);
		return DaoRepository.getEventsDao().delete(e);
	}

}
