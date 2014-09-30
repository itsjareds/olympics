package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Heat;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.main.School;
import edu.clemson.cs.cu.cpsc3720.main.Teacher;

public class DaoRepository {
	private static DatabaseAccessObject<Athlete> athletes;
	private static DatabaseAccessObject<Event> events;
	private static DatabaseAccessObject<Heat> heats;
	private static DatabaseAccessObject<Registration> registrations;
	private static DatabaseAccessObject<School> schools;
	private static DatabaseAccessObject<Teacher> teachers;

	private DaoRepository() {

	}

	public static DatabaseAccessObject<Athlete> getAthletes() {
		if (athletes == null)
			athletes = new DatabaseAccessObject<Athlete>();
		return athletes;
	}

	public static DatabaseAccessObject<Event> getEvents() {
		if (events == null)
			events = new DatabaseAccessObject<Event>();
		return events;
	}

	public static DatabaseAccessObject<Heat> getHeats() {
		if (heats == null)
			heats = new DatabaseAccessObject<Heat>();
		return heats;
	}

	public static DatabaseAccessObject<Registration> getRegistrations() {
		if (registrations == null)
			registrations = new DatabaseAccessObject<Registration>();
		return registrations;
	}

	public static DatabaseAccessObject<School> getSchools() {
		if (schools == null)
			schools = new DatabaseAccessObject<School>();
		return schools;
	}

	public static DatabaseAccessObject<Teacher> getTeachers() {
		if (teachers == null)
			teachers = new DatabaseAccessObject<Teacher>();
		return teachers;
	}
}
