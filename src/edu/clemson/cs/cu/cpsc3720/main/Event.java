package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class Event extends DatabaseObject implements Comparable<Event> {

	private String eventCode;
	private String eventName;
	private String scoreUnit;
	private Integer scoreMin;
	private Integer scoreMax;
	private Integer sortSeq;

	/**
	 * Constructor for Event.
	 * @param eventCode String
	 * @param eventName String
	 * @param scoreUnit String
	 * @param scoreMin Integer
	 * @param scoreMax Integer
	 * @param sortSeq Integer
	 */
	public Event(String eventCode, String eventName, String scoreUnit,
			Integer scoreMin, Integer scoreMax, Integer sortSeq) {
		super();
		this.eventCode = eventCode;
		this.eventName = eventName;
		this.scoreUnit = scoreUnit;
		this.scoreMin = scoreMin;
		this.scoreMax = scoreMax;
		this.sortSeq = sortSeq;
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
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @param scoreUnit the scoreUnit to set
	 */
	public void setScoreUnit(String scoreUnit) {
		this.scoreUnit = scoreUnit;
	}

	/**
	 * @param scoreMin the scoreMin to set
	 */
	public void setScoreMin(Integer scoreMin) {
		this.scoreMin = scoreMin;
	}

	/**
	 * @param scoreMax the scoreMax to set
	 */
	public void setScoreMax(Integer scoreMax) {
		this.scoreMax = scoreMax;
	}

	/**
	 * @param sortSeq the sortSeq to set
	 */
	public void setSortSeq(Integer sortSeq) {
		this.sortSeq = sortSeq;
	}

	/**
	 * Method extractMajorScore.
	 * @param score Integer @return Integer
	 */
	public static Integer extractMajorScore(Integer score) {
		return score / 100;
	}

	/**
	 * Method extractMinorScore.
	 * @param score Integer @return Integer
	 */
	public static Integer extractMinorScore(Integer score) {
		return score % 100;
	}

	/**
	 * Method scoreToString.
	 * @param score Integer @return String
	 */
	public static String scoreToString(Integer score) {
		Integer ft = score / 100;
		Integer in = score % 100;
		return ft.toString() + in.toString();
	}

	/**
	 * Method combineMinorMajorScores.
	 * @param major Integer
	 * @param minor Integer @return Integer
	 */
	public static Integer combineMajorMinorScores(Integer major, Integer minor) {
		return new Integer(major * 100 + minor);
	}

	/**
	 * Method toString. @return String
	 */
	@Override
	public String toString() {
		return this.getEventName();
	}

	/**
	 * Method compareTo.
	 * @param o Event @return int
	 */
	@Override
	public int compareTo(Event o) {
		int retVal = 0;
		retVal = this.getEventName().compareTo(o.getEventName());
		return retVal;
	}

	/**
	 * Method equals.
	 * @param o Object @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof Event) {
			Event e = (Event) o;
			String thisEvent = this.getDbId() + this.getEventName();
			String thatEvent = e.getDbId() + e.getEventName();
			if (thisEvent.equals(thatEvent))
				retVal = true;
		}
		return retVal;
	}

	/**
	 * Method deleteReference.
	 * @param subject DeletionSubject @see
	 *            edu.clemson.cs.cu.cpsc3720.main.interfaces
	 *            .DeletionObserver#deleteReference(DeletionSubject)
	 */
	@Override
	public void deleteReference(DeletionSubject subject) {
		// No references to delete
	}
}
