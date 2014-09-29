package edu.clemson.cs.cu.cpsc3720.main;

import java.sql.Time;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Heat implements DatabaseSerializable {

	private transient String dbId;
	private Event event;
	private String gender;
	private Integer minAge;
	private Integer maxAge;
	private Time time;

	public Heat(Event event, String gender, Integer minAge, Integer maxAge,
			Time time) {
		super();
		this.event = event;
		this.gender = gender;
		this.minAge = minAge;
		this.time = time;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * @return the minAge
	 */
	public Integer getMinAge() {
		return this.minAge;
	}

	/**
	 * @return the maxAge
	 */
	public Integer getMaxAge() {
		return this.maxAge;
	}

	/**
	 * @return the time
	 */
	public Time getTime() {
		return this.time;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param minAge
	 *            the minAge to set
	 */
	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	/**
	 * @param maxAge
	 *            the maxAge to set
	 */
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return this.event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
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
