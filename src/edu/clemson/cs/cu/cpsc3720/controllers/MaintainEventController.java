package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Event;

public class MaintainEventController {

	public void saveEvent(Event e) {
		System.out.println("Saving event " + e);
		DaoRepository.getEventsDao().save(e);
	}

	public Event deleteEvent(Event e) {
		System.out.println("Deleting event " + e);
		return DaoRepository.getEventsDao().delete(e);
	}

}
