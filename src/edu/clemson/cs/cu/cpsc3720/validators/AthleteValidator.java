package edu.clemson.cs.cu.cpsc3720.validators;

import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.DatabaseObject;

public class AthleteValidator extends DatabaseObjectValidator {

	public boolean isValid(Athlete a) throws InvalidObjectException {
		boolean ret = isValid((DatabaseObject) a);

		return ret;
	}
}
