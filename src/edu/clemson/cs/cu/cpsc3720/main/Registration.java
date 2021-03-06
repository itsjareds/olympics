package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.controllers.RegisterAthleteController;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * <h1>Registration</h1>
 * <p>
 * Main Registration class that holds database references to a and event and an
 * athlete as well as that athletes qualifing score.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class Registration extends DatabaseObject implements
		Comparable<Registration> {

	private transient Event event;
	private String eventRef;
	private transient Athlete athlete;
	private String athleteRef;
	private Integer score;

	public Registration() {
		super();
	}

	/**
	 * Constructor for Registration.
	 * @param eventRef String
	 * @param athleteRef String
	 * @param score Integer
	 */
	public Registration(String eventRef, String athleteRef, Integer score) {
		this.eventRef = eventRef;
		this.athleteRef = athleteRef;
		this.score = score;
	}

	public void loadRefs() {
		loadEvent();
		loadAthlete();
	}

	public void loadEvent() {
		this.event = DaoRepository.getEventsDao().query(eventRef);
	}

	public void loadAthlete() {
		this.athlete = DaoRepository.getAthletesDao().query(athleteRef);
	}

	/**
	 * Method getEventRef.
	 * @return String
	 */
	public String getEventRef() {
		return eventRef;
	}

	/**
	 * Method setEventRef.
	 * @param eventRef String
	 */
	public void setEventRef(String eventRef) {
		Event oldEvent = DaoRepository.getEventsDao().query(this.eventRef);
		Event newEvent = DaoRepository.getEventsDao().query(eventRef);
		if (newEvent != null) {
			if (oldEvent != null)
				oldEvent.unregisterDeletionObserver(this);
			newEvent.registerDeletionObserver(this);
			this.eventRef = eventRef;
		}
	}

	/**
	 * Method getAthleteRef.
	 * @return String
	 */
	public String getAthleteRef() {
		return athleteRef;
	}

	/**
	 * Method setAthleteRef.
	 * @param athleteRef String
	 */
	public void setAthleteRef(String athleteRef) {
		Athlete oldAthlete = DaoRepository.getAthletesDao().query(
				this.athleteRef);
		Athlete newAthlete = DaoRepository.getAthletesDao().query(athleteRef);
		if (newAthlete != null) {
			if (oldAthlete != null)
				oldAthlete.unregisterDeletionObserver(this);
			newAthlete.registerDeletionObserver(this);
			this.athleteRef = athleteRef;
		}
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		loadEvent();
		return this.event;
	}

	/**
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		loadAthlete();
		return this.athlete;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return this.score;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @param athlete the athlete to set
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * Method compareTo.
	 * @param o Registration
	 * @return int
	 */
	@Override
	public int compareTo(Registration o) {
		int retVal = 0;
		retVal = this.getDbId().compareTo(o.getDbId());
		return retVal;
	}

	/**
	 * Method deleteReference.
	 * @param subject DeletionSubject
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces
	 *      .DeletionObserver#deleteReference(DeletionSubject)
	 */
	@Override
	public void deleteReference(DeletionSubject subject) {
		if (subject instanceof Athlete) {
			// Deleted last reference to Athlete,
			// so Registration should also be deleted
			RegisterAthleteController rac = new RegisterAthleteController();
			rac.deleteRegistration(this);
		} else if (subject instanceof Event) {
			// Deleted last reference to Event,
			// so Registration should also be deleted
			RegisterAthleteController rac = new RegisterAthleteController();
			rac.deleteRegistration(this);
		}
	}

	/**
	 * Method runHooks.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver#runHooks()
	 */
	@Override
	public void runHooks() {
		setEventRef(getEventRef());
		setAthleteRef(getAthleteRef());
	}

	/**
	 * Method copy.
	 * @param o DatabaseSerializable
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#copy(DatabaseSerializable)
	 */
	@Override
	public void copy(DatabaseSerializable o) {
		if (o instanceof Registration) {
			Registration r = (Registration) o;

			this.setEventRef(r.getEventRef());
			this.setAthleteRef(r.getAthleteRef());
			this.setScore(r.getScore());
		}
	}

}
