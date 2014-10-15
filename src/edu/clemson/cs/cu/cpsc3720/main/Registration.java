package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Registration implements DatabaseSerializable,
		Comparable<Registration> {

	private transient String dbId;
	private transient Event event;
	private String eventRef;
	private transient Athlete athlete;
	private String athleteRef;
	private Integer score;

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
		this.event = DaoRepository.getEvents().query(Event.class, eventRef);
	}

	public void loadAthlete() {
		this.athlete = DaoRepository.getAthletes().query(Athlete.class,
				athleteRef);
	}

	public String getEventRef() {
		return eventRef;
	}

	public void setEventRef(String eventRef) {
		this.eventRef = eventRef;
	}

	public String getAthleteRef() {
		return athleteRef;
	}

	public void setAthleteRef(String athleteRef) {
		this.athleteRef = athleteRef;
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
	 * @param event
	 *            the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @param athlete
	 *            the athlete to set
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String getDbId() {
		return this.dbId;
	}

	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

	@Override
	public int compareTo(Registration o) {
		int retVal = 0;
		retVal = this.getDbId().compareTo(o.getDbId());
		return retVal;
	}

}
