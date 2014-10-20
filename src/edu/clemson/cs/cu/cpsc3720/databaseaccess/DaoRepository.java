package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

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

	public static void initialize() {
		ODatabaseDocumentTx db = DatabaseAccessObject.getDb();

		/* Create schema in case of empty database */

		if (!db.getMetadata().getSchema().existsClass("Athlete"))
			db.getMetadata().getSchema().createClass("Athlete");

		if (!db.getMetadata().getSchema().existsClass("Event"))
			db.getMetadata().getSchema().createClass("Event");

		if (!db.getMetadata().getSchema().existsClass("Heat"))
			db.getMetadata().getSchema().createClass("Heat");

		if (!db.getMetadata().getSchema().existsClass("Registration"))
			db.getMetadata().getSchema().createClass("Registration");

		if (!db.getMetadata().getSchema().existsClass("School"))
			db.getMetadata().getSchema().createClass("School");

		if (!db.getMetadata().getSchema().existsClass("Teacher"))
			db.getMetadata().getSchema().createClass("Teacher");
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
