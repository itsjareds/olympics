package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

public class Event {

	private String eventCode;
	private String eventName;
	private String scoreUnit;
	private Integer scoreMin;
	private Integer scoreMax;
	private Integer sortSeq;
	private ArrayList<Registration> registrations;
	private ArrayList<Heat> heats;
	private Integer numHeats;

	public Event(String eventCode, String eventName, String scoreUnit,
			Integer scoreMin, Integer scoreMax, Integer sortSeq,
			ArrayList<Registration> registrations, ArrayList<Heat> heats) {
		super();
		this.eventCode = eventCode;
		this.eventName = eventName;
		this.scoreUnit = scoreUnit;
		this.scoreMin = scoreMin;
		this.scoreMax = scoreMax;
		this.sortSeq = sortSeq;
		this.registrations = registrations;
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
	 * @return the scoreUnit
	 */
	public String getScoreUnit() {
		return this.scoreUnit;
	}

	/**
	 * @return the scoreMin
	 */
	public Integer getScoreMin() {
		return this.scoreMin;
	}

	/**
	 * @return the scoreMax
	 */
	public Integer getScoreMax() {
		return this.scoreMax;
	}

	/**
	 * @return the sortSeq
	 */
	public Integer getSortSeq() {
		return this.sortSeq;
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
	 * @param scoreUnit
	 *            the scoreUnit to set
	 */
	public void setScoreUnit(String scoreUnit) {
		this.scoreUnit = scoreUnit;
	}

	/**
	 * @param scoreMin
	 *            the scoreMin to set
	 */
	public void setScoreMin(Integer scoreMin) {
		this.scoreMin = scoreMin;
	}

	/**
	 * @param scoreMax
	 *            the scoreMax to set
	 */
	public void setScoreMax(Integer scoreMax) {
		this.scoreMax = scoreMax;
	}

	/**
	 * @param sortSeq
	 *            the sortSeq to set
	 */
	public void setSortSeq(Integer sortSeq) {
		this.sortSeq = sortSeq;
	}

	/**
	 * @return the registrations
	 */
	public ArrayList<Registration> getRegistrations() {
		return this.registrations;
	}

	/**
	 * @param registrations
	 *            the registrations to set
	 */
	public void setRegistrations(ArrayList<Registration> registrations) {
		this.registrations = registrations;
	}

	/**
	 * @return the heats
	 */
	public ArrayList<Heat> getHeats() {
		return this.heats;
	}

	/**
	 * @param heats
	 *            the heats to set
	 */
	public void setHeats(ArrayList<Heat> heats) {
		this.heats = heats;
	}

	/**
	 * @return the numHeats
	 */
	public Integer getNumHeats() {
		return 0;
	}

	/**
	 * @param numHeats
	 *            the numHeats to set
	 */
	public void setNumHeats(Integer numHeats) {
		this.numHeats = numHeats;
	}
}
