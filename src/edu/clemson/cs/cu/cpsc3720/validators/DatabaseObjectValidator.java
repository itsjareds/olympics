package edu.clemson.cs.cu.cpsc3720.validators;

import edu.clemson.cs.cu.cpsc3720.main.DatabaseObject;

public abstract class DatabaseObjectValidator {

	public boolean isValid(DatabaseObject dbObject)
			throws InvalidObjectException {
		boolean ret = true;
		String dbId = dbObject.getDbId();

		ret &= (dbId != "");
		if (!ret)
			throw new InvalidObjectException("Empty dbId");

		return ret;
	}

	@SuppressWarnings("serial")
	public static class InvalidObjectException extends Exception {
		public InvalidObjectException(String message) {
			super(message);
		}
	}
}
