package edu.clemson.cs.cu.cpsc3720.validators;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.DatabaseObject;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.main.School;
import edu.clemson.cs.cu.cpsc3720.main.Teacher;

public class AthleteValidator extends DatabaseObjectValidator {

	public boolean isValid(Athlete a) throws InvalidObjectException {
		boolean ret = isValid((DatabaseObject) a);

		String teacherRef = a.getTeacherRef();
		String firstName = a.getFirstName();
		String lastName = a.getLastName();
		Integer age = a.getAge();
		String gender = a.getGender();
		String schoolRef = a.getSchoolRef();
		ArrayList<String> regRefs = a.getRegRefs();

		// Ensure non null fields
		ret &= (teacherRef != null && firstName != null && lastName != null
				&& age != null && gender != null && schoolRef != null && regRefs != null);
		if (!ret)
			throw new InvalidObjectException("Null field in Athlete");

		// Validate teacher ref
		Teacher checkTeacher = DaoRepository.getTeachersDao().query(teacherRef);
		ret &= (checkTeacher != null);
		if (!ret)
			throw new InvalidObjectException("Invalid teacher");

		// Validate first name
		firstName = firstName.trim();
		ret &= (firstName.length() > 0 && firstName.matches("[a-zA-Z]+"));
		if (!ret)
			throw new InvalidObjectException("Invalid first name");

		// Validate last name
		lastName = lastName.trim();
		ret &= (lastName.length() > 0 && lastName.matches("[a-zA-Z]+"));
		if (!ret)
			throw new InvalidObjectException("Invalid last name");

		// Validate age
		ret &= (age >= 6 && age <= 99);
		if (!ret)
			throw new InvalidObjectException("Invalid age");

		// Validate gender
		ret &= (gender.equals("M") || gender.equals("F"));
		if (!ret)
			throw new InvalidObjectException("Invalid gender");

		// Validate school ref
		School checkSchool = DaoRepository.getSchoolsDao().query(schoolRef);
		ret &= (checkSchool != null);
		if (!ret)
			throw new InvalidObjectException("Invalid school");

		// Validate registration refs
		for (String ref : regRefs) {
			Registration checkReg = DaoRepository.getRegistrationsDao().query(
					ref);
			ret &= (checkReg != null);
			if (!ret)
				throw new InvalidObjectException("Invalid registration");
		}

		return ret;
	}
}
