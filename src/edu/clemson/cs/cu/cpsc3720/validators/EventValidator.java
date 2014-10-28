package edu.clemson.cs.cu.cpsc3720.validators;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.DatabaseObject;
import edu.clemson.cs.cu.cpsc3720.main.Event;

public class EventValidator extends DatabaseObjectValidator {

	public boolean isValid(Event e) throws InvalidObjectException {
		boolean ret = isValid((DatabaseObject) e);

		String eventCode = e.getEventCode();
		String eventName = e.getEventName();
		String scoreUnit = e.getScoreUnit();
		Integer scoreMax = e.getScoreMax();
		Integer scoreMin = e.getScoreMin();
		Integer sortSeq = e.getSortSeq();

		// Ensure non-null fields
		ret &= (eventCode != null && eventName != null && scoreUnit != null
				&& scoreMax != null && scoreMin != null && sortSeq != null);
		if (!ret)
			throw new InvalidObjectException("Null Event field");

		// Validate eventCode
		eventCode = eventCode.trim();
		ret &= (!eventCode.equals(""));
		for (Event event : DaoRepository.getEventsDao().objects) {
			if (eventCode.equals(event.getEventCode().trim())
					&& !event.getDbId().equals(e.getDbId())) {
				ret = false;
				break;
			}
		}
		if (!ret)
			throw new InvalidObjectException("Invalid event code");

		// Validate eventName
		eventName = eventName.trim();
		ret &= (!eventName.equals(""));
		if (!ret)
			throw new InvalidObjectException("Invalid event name");

		// Validate scoreUnit
		scoreUnit = scoreUnit.trim().toUpperCase();
		ret &= (scoreUnit.equals("D") || scoreUnit.equals("T") || scoreUnit
				.equals("N"));
		if (!ret)
			throw new InvalidObjectException("Invalid score unit");

		// Validate scoreMax and scoreMin
		ret &= (scoreMax >= scoreMin && scoreMin >= 0);
		if (!ret)
			throw new InvalidObjectException("Invalid score bounds");

		// Validate sortSeq
		ret &= true;

		return ret;
	}
}
