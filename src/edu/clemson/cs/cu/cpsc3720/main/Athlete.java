package edu.clemson.cs.cu.cpsc3720.main;

public class Athlete {

	private String groupCode;
	private String schoolName;
	private String groupLeader;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String eventCode;
	private String eventName;
	private Integer score;

	public Athlete(String groupCode, String schoolName, String groupLeader,
			String firstName, String lastName, Integer age, String gender,
			String eventCode, String eventName, Integer score) {
		super();
		this.groupCode = groupCode;
		this.schoolName = schoolName;
		this.groupLeader = groupLeader;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.eventCode = eventCode;
		this.eventName = eventName;
		this.score = score;
	}

	/**
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return this.groupCode;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return this.schoolName;
	}

	/**
	 * @return the groupLeader
	 */
	public String getGroupLeader() {
		return this.groupLeader;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
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
	 * @return the score
	 */
	public Integer getScore() {
		return this.score;
	}

	/**
	 * @param groupCode
	 *            the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	/**
	 * @param schoolName
	 *            the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @param groupLeader
	 *            the groupLeader to set
	 */
	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @param score
	 *            the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
