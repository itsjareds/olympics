package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

public class Athlete {

	private Teacher groupLeader;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private School school;
	private ArrayList<Registration> registrations;

	public Athlete(Teacher groupLeader, String firstName, String lastName,
			Integer age, String gender, School school,
			ArrayList<Registration> registrations) {
		super();
		this.groupLeader = groupLeader;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.school = school;
		this.registrations = registrations;
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
	 * @return the groupLeader
	 */
	public Teacher getGroupLeader() {
		return this.groupLeader;
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		return this.school;
	}

	/**
	 * @return the registrations
	 */
	public ArrayList<Registration> getRegistrations() {
		return this.registrations;
	}

	/**
	 * @param groupLeader
	 *            the groupLeader to set
	 */
	public void setGroupLeader(Teacher groupLeader) {
		this.groupLeader = groupLeader;
	}

	/**
	 * @param school
	 *            the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * @param registrations
	 *            the registrations to set
	 */
	public void setRegistrations(ArrayList<Registration> registrations) {
		this.registrations = registrations;
	}
}
