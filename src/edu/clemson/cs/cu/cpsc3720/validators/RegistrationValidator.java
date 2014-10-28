package edu.clemson.cs.cu.cpsc3720.validators;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.DatabaseObject;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Registration;

public class RegistrationValidator extends DatabaseObjectValidator {

	public boolean isValid(Registration r) throws InvalidObjectException {
		boolean ret = isValid((DatabaseObject) r);

		String eventRef = r.getEventRef();
		String athleteRef = r.getAthleteRef();
		Integer score = r.getScore();

		ret &= (eventRef != null && athleteRef != null && score != null);

		// Ensure non null fields
		if (!ret)
			throw new InvalidObjectException("Null Registration field");

		// Validate eventRef
		eventRef = eventRef.trim();
		Event checkEvent = DaoRepository.getEventsDao().query(eventRef);
		ret &= (checkEvent != null);
		if (!ret)
			throw new InvalidObjectException("Event does not exist");

		// Validate athleteRef
		athleteRef = athleteRef.trim();
		Athlete checkAthlete = DaoRepository.getAthletesDao().query(athleteRef);
		ret &= (checkAthlete != null);
		if (!ret)
			throw new InvalidObjectException("Athlete does not exist");

		// Validate score
		ret &= (score >= checkEvent.getScoreMin() && score <= checkEvent
				.getScoreMax());
		if (!ret)
			throw new InvalidObjectException("Invalid score");

		ret &= (checkAthlete.getRegistrations().size() < 2);
		if (!ret)
			throw new InvalidObjectException(
					"Cannot excede more than 2 registrations");

		return ret;
	}
}
