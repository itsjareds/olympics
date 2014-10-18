package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

/**
 */
public class Registration implements DatabaseSerializable,
		Comparable<Registration> {

	private transient String dbId;
	private transient Event event;
	private String eventRef;
	private transient Athlete athlete;
	private String athleteRef;
	private Integer score;

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
		this.eventRef = eventRef;
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
		this.athleteRef = athleteRef;
	}

	/** @return the event
	 */
	public Event getEvent() {
		loadEvent();
		return this.event;
	}

	/** @return the athlete
	 */
	public Athlete getAthlete() {
		loadAthlete();
		return this.athlete;
	}

	/** @return the score
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
	 * Method getDbId.
	 * @return String
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#getDbId()
	 */
	@Override
	public String getDbId() {
		return this.dbId;
	}

	/**
	 * Method setDbId.
	 * @param id String
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#setDbId(String)
	 */
	@Override
	public void setDbId(String id) {
		this.dbId = id;
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

}
