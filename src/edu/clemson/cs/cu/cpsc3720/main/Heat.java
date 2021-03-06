package edu.clemson.cs.cu.cpsc3720.main;

import java.text.DecimalFormat;

import edu.clemson.cs.cu.cpsc3720.controllers.MaintainHeatController;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * <h1>Heat</h1>
 * <p>
 * Main Heat class that holds database references to an Event and stores the
 * information of a single heat.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class Heat extends DatabaseObject implements Comparable<Heat> {

	private transient Event event;
	private String eventRef;
	private String gender;
	private Integer minAge;
	private Integer maxAge;
	private String time;
	private Integer numHeats;

	/**
	 * Empty constructor for Heat.
	 */
	public Heat() {
		super();
	}

	/**
	 * Constructor for Heat.
	 * @param eventRef String
	 * @param gender String
	 * @param minAge Integer
	 * @param maxAge Integer
	 * @param time String
	 * @param numHeats int
	 */
	public Heat(String eventRef, String gender, Integer minAge, Integer maxAge,
			String time, Integer numHeats) {
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
		this.event = DaoRepository.getEventsDao().query(eventRef);
	}

	/**
	 * Method getNumHeats.
	 * @return Integer
	 */
	public Integer getDivision() {
		return numHeats;
	}

	/**
	 * Method setNumHeats.
	 * @param numHeats Integer
	 */
	public void setNumHeats(Integer numHeats) {
		this.numHeats = numHeats;
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
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param minAge the minAge to set
	 */
	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	/**
	 * @param maxAge the maxAge to set
	 */
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * @param time the time to set
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
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Method extractHour.
	 * @param time String
	 * @return Integer
	 */
	public static Integer extractHour(String time) {
		Integer ret = 0;
		if (time != null) {
			int depth = 0;
			String[] tokens = time.split(":");
			if (tokens.length > depth) {
				try {
					ret = Integer.parseInt(tokens[depth]);
				} catch (NumberFormatException e) {
					ret = 0;
				}
			}
		}
		return ret;
	}

	/**
	 * Method extractMinute.
	 * @param time String
	 * @return Integer
	 */
	public static Integer extractMinute(String time) {
		Integer ret = 0;
		if (time != null) {
			int depth = 1;
			String[] tokens = time.split(":");
			if (tokens.length > depth) {
				try {
					ret = Integer.parseInt(tokens[depth]);
				} catch (NumberFormatException e) {
					ret = 0;
				}
			}
		}
		return ret;
	}

	/**
	 * Method extractSecond.
	 * @param time String
	 * @return Integer
	 */
	public static Integer extractSecond(String time) {
		Integer ret = 0;
		if (time != null) {
			int depth = 2;
			String[] tokens = time.split(":");
			if (tokens.length > depth) {
				try {
					ret = Integer.parseInt(tokens[depth]);
				} catch (NumberFormatException e) {
					ret = 0;
				}
			}
		}
		return ret;
	}

	/**
	 * Method createTimeString.
	 * @param hour Integer
	 * @param minute Integer
	 * @param second Integer
	 * @return String
	 */
	public static String createTimeString(Integer hour, Integer minute,
			Integer second) {
		DecimalFormat df = new DecimalFormat("00");
		String h = df.format(hour);
		String m = df.format(minute);
		String s = df.format(second);
		return h + ":" + m + ":" + s;
	}

	/**
	 * Method deleteReference.
	 * @param subject DeletionSubject
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces
	 *      .DeletionObserver#deleteReference(DeletionSubject)
	 */
	@Override
	public void deleteReference(DeletionSubject subject) {
		if (subject instanceof Event) {
			// Deleted last reference to Event,
			// so Heat should also be deleted
			MaintainHeatController mhc = new MaintainHeatController();
			mhc.removeHeat(this);
		}
	}

	/**
	 * Method runHooks.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver#runHooks()
	 */
	@Override
	public void runHooks() {
		setEventRef(getEventRef());
	}

	@Override
	public int compareTo(Heat h) {
		int retVal = 0;
		retVal = this.getTime().compareTo(h.getTime());
		if (retVal == 0)
			retVal = this.getDivision().compareTo(h.getDivision());
		return retVal;
	}

	/**
	 * Method copy.
	 * @param o DatabaseSerializable
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#copy(DatabaseSerializable)
	 */
	@Override
	public void copy(DatabaseSerializable o) {
		if (o instanceof Heat) {
			Heat h = (Heat) o;

			this.setEventRef(h.getEventRef());
			this.setGender(h.getGender());
			this.setMinAge(h.getMinAge());
			this.setMaxAge(h.getMaxAge());
			this.setTime(h.getTime());
			this.setNumHeats(h.getDivision());
		}
	}

}
