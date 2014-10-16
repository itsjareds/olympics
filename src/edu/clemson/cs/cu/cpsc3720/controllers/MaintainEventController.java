package edu.clemson.cs.cu.cpsc3720.controllers;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Event;

public class MaintainEventController {

	public void saveEvent(Event e) {
		System.out.println("Saving event " + e);
		DaoRepository.getEvents().save(e);
	}

	public void deleteEvent(Event e) {
		System.out.println("Deleting event " + e);
		Event event = DaoRepository.getEvents().delete(e);
		System.out.println("Deleted event " + event);
	}

}
