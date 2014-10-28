package edu.clemson.cs.cu.cpsc3720.validators;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.DatabaseObject;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Heat;

public class HeatValidator extends DatabaseObjectValidator {

	/**
	 * Method isValid.
	 * @param h Heat
	 * @return bool Boolean
	 * @throws InvalidObjectException
	 * @see edu.clemson.cs.cu.cpsc3720.DatabaseObjectValidator#isValid(DatabaseObject)
	 */
	public boolean isValid(Heat h) throws InvalidObjectException {
		boolean ret = isValid((DatabaseObject) h);

		String eventRef = h.getEventRef();
		String gender = h.getGender();
		Integer minAge = h.getMinAge();
		Integer maxAge = h.getMaxAge();
		String time = h.getTime();
		Integer division = h.getDivision();

		// Ensure non-null fields
		ret &= (eventRef != null && gender != null && minAge != null
				&& maxAge != null && time != null && division != null);
		if (!ret)
			throw new InvalidObjectException("Null Event field");

		// Validate eventRef
		eventRef = eventRef.trim();
		Event event = DaoRepository.getEventsDao().query(eventRef);
		ret &= (!eventRef.equals("") && event != null);
		if (!ret)
			throw new InvalidObjectException("Invalid event reference");

		// Validate gender
		gender = gender.trim().toUpperCase();
		ret &= (gender.equals("M") || gender.equals("F") || gender.equals("B"));
		if (!ret)
			throw new InvalidObjectException("Invalid gender");

		// Validate minAge and maxAge
		ret &= (maxAge >= minAge && minAge >= 0);
		if (!ret)
			throw new InvalidObjectException("Invalid age bounds");

		// Validate time
		time = time.trim();
		Integer hour = Heat.extractHour(time);
		Integer min = Heat.extractMinute(time);
		Integer sec = Heat.extractSecond(time);
		ret &= (time != "");
		ret &= (hour >= 0 && hour <= 24);
		ret &= (min >= 0 && min <= 99);
		ret &= (sec >= 0 && sec <= 99);
		if (!ret)
			throw new InvalidObjectException("Invalid time");

		// Validate division
		ret &= (division >= 0);

		return ret;
	}
}
