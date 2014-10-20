package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import edu.clemson.cs.cu.cpsc3720.main.Athlete;
import edu.clemson.cs.cu.cpsc3720.main.Event;
import edu.clemson.cs.cu.cpsc3720.main.Heat;
import edu.clemson.cs.cu.cpsc3720.main.Registration;
import edu.clemson.cs.cu.cpsc3720.main.School;
import edu.clemson.cs.cu.cpsc3720.main.Teacher;

/**
 */
public class DaoRepository {
	private static DatabaseAccessObject<Athlete> athletesDao;
	private static DatabaseAccessObject<Event> eventsDao;
	private static DatabaseAccessObject<Heat> heatsDao;
	private static DatabaseAccessObject<Registration> registrationsDao;
	private static DatabaseAccessObject<School> schoolsDao;
	private static DatabaseAccessObject<Teacher> teachersDao;

	private DaoRepository() {

	}

	/**
	 * Method getAthletesDao.
	 * @return DatabaseAccessObject<Athlete>
	 */
	public static DatabaseAccessObject<Athlete> getAthletesDao() {
		if (athletesDao == null)
			athletesDao = new DatabaseAccessObject<Athlete>(Athlete.class);
		return athletesDao;
	}

	/**
	 * Method getEventsDao.
	 * @return DatabaseAccessObject<Event>
	 */
	public static DatabaseAccessObject<Event> getEventsDao() {
		if (eventsDao == null)
			eventsDao = new DatabaseAccessObject<Event>(Event.class);
		return eventsDao;
	}

	/**
	 * Method getHeatsDao.
	 * @return DatabaseAccessObject<Heat>
	 */
	public static DatabaseAccessObject<Heat> getHeatsDao() {
		if (heatsDao == null)
			heatsDao = new DatabaseAccessObject<Heat>(Heat.class);
		return heatsDao;
	}

	/**
	 * Method getRegistrationsDao.
	 * @return DatabaseAccessObject<Registration>
	 */
	public static DatabaseAccessObject<Registration> getRegistrationsDao() {
		if (registrationsDao == null)
			registrationsDao = new DatabaseAccessObject<Registration>(
					Registration.class);
		return registrationsDao;
	}

	/**
	 * Method getSchoolsDao.
	 * @return DatabaseAccessObject<School>
	 */
	public static DatabaseAccessObject<School> getSchoolsDao() {
		if (schoolsDao == null)
			schoolsDao = new DatabaseAccessObject<School>(School.class);
		return schoolsDao;
	}

	/**
	 * Method getTeachersDao.
	 * @return DatabaseAccessObject<Teacher>
	 */
	public static DatabaseAccessObject<Teacher> getTeachersDao() {
		if (teachersDao == null)
			teachersDao = new DatabaseAccessObject<Teacher>(Teacher.class);
		return teachersDao;
	}

	public static void runHooks() {
		for (Athlete a : DaoRepository.getAthletesDao().objects)
			a.runHooks();
		for (Registration r : DaoRepository.getRegistrationsDao().objects)
			r.runHooks();
		for (Heat h : DaoRepository.getHeatsDao().objects)
			h.runHooks();
	}
}
