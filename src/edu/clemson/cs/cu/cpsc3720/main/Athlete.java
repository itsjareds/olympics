package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Athlete implements DatabaseSerializable, Comparable<Athlete> {

	private transient String dbId;
	private transient Teacher teacher;
	private String teacherRef;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private transient School school;
	private String schoolRef;
	private transient ArrayList<Registration> registrations;
	private ArrayList<String> regRefs;

	public Athlete(String teacherRef, String firstName, String lastName,
			Integer age, String gender, String schoolRef,
			ArrayList<String> regRefs) {
		super();
		this.teacherRef = teacherRef;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.schoolRef = schoolRef;
		this.regRefs = regRefs;
	}

	public void loadRefs() {
		loadTeacher();
		loadSchool();
		loadRegistrations();
	}

	public Teacher getTeacher() {
		loadTeacher();
		return teacher;
	}

	public void loadTeacher() {
		teacher = DaoRepository.getTeachersDao().query(Teacher.class, teacherRef);
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTeacherRef() {
		return teacherRef;
	}

	public void setTeacherRef(String teacherRef) {
		this.teacherRef = teacherRef;
	}

	public String getSchoolRef() {
		return schoolRef;
	}

	public void setSchoolRef(String schoolRef) {
		this.schoolRef = schoolRef;
	}

	public ArrayList<String> getRegRefs() {
		return regRefs;
	}

	public void setRegRefs(ArrayList<String> regRefs) {
		this.regRefs = regRefs;
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
		return this.teacher;
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		loadSchool();
		return this.school;
	}

	public void loadSchool() {
		school = DaoRepository.getSchoolsDao().query(School.class, schoolRef);
	}

	/**
	 * @return the registrations
	 */
	public ArrayList<Registration> getRegistrations() {
		loadRegistrations();
		return this.registrations;
	}

	public void loadRegistrations() {
		if (registrations == null)
			registrations = new ArrayList<Registration>();
		registrations.clear();
		for (String ref : regRefs)
			registrations.add(DaoRepository.getRegistrationsDao().query(
					Registration.class, ref));
	}

	/**
	 * @param groupLeader
	 *            the groupLeader to set
	 */
	public void setGroupLeader(Teacher groupLeader) {
		this.teacher = groupLeader;
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

	@Override
	public String getDbId() {
		return this.dbId;
	}

	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

	@Override
	public int compareTo(Athlete o) {
		int retVal = 0;
		retVal = this.getLastName().compareTo(o.getLastName());
		if (retVal == 0)
			retVal = this.getFirstName().compareTo(o.getFirstName());
		return retVal;
	}
}
