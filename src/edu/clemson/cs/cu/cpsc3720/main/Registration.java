package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Registration implements DatabaseSerializable {

	private transient String dbId;
	private Event event;
	private Athlete athlete;
	private Integer score;
	private String eventCode;

	public Registration(Event event, Athlete athlete, Integer score,
			String eventCode) {
		this.event = event;
		this.athlete = athlete;
		this.score = score;
		this.eventCode = eventCode;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return this.event;
	}

	/**
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return this.athlete;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return this.score;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return this.eventCode;
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

	/**
	 * @param eventCode
	 *            the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	@Override
	public String getDbId() {
		return dbId;
	}

	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}
}
