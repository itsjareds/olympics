package edu.clemson.cs.cu.cpsc3720.main;

import java.sql.Time;

public class Heat {

	private String eventCode;
	private String eventName;
	private String gender;
	private Integer minAge;
	private Integer maxAge;
	private Time time;
	private Integer numHeats;

	public Heat(String eventCode, String eventName, String gender,
			Integer minAge, Integer maxAge, Time time, Integer numHeats) {
		this.eventCode = eventCode;
		this.eventName = eventName;
		this.gender = gender;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.time = time;
		this.numHeats = numHeats;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return this.eventCode;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return this.eventName;
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
	 * @return the numHeats
	 */
	public Integer getNumHeats() {
		return this.numHeats;
	}

	/**
	 * @param eventCode
	 *            the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
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
	 * @param numHeats
	 *            the numHeats to set
	 */
	public void setNumHeats(Integer numHeats) {
		this.numHeats = numHeats;
	}

}
