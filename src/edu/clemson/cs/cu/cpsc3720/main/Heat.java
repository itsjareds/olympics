package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Heat implements DatabaseSerializable {

	private transient String dbId;
	private transient Event event;
	private String eventRef;
	private String gender;
	private Integer minAge;
	private Integer maxAge;
	private String time;
	private Integer numHeats;

	public Heat(String eventRef, String gender, Integer minAge, Integer maxAge,
			String time, int numHeats) {
		super();
		this.eventRef = eventRef;
		this.gender = gender;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.time = time;
		this.numHeats = numHeats;
	}

	public void loadRefs() {
		loadEvent();
	}

	public void loadEvent() {
		this.event = DaoRepository.getEventsDao().query(Event.class, eventRef);
	}

	public Integer getNumHeats() {
		return numHeats;
	}

	public void setNumHeats(Integer numHeats) {
		this.numHeats = numHeats;
	}

	public String getEventRef() {
		return eventRef;
	}

	public void setEventRef(String eventRef) {
		this.eventRef = eventRef;
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
	public String getTime() {
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
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		loadEvent();
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
		return this.dbId;
	}

	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

}
