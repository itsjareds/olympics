package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import edu.clemson.cs.cu.cpsc3720.controllers.MaintainAthleteController;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 */
public class Athlete extends DatabaseObject implements Comparable<Athlete> {

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

	/**
	 * Constructor for Athlete.
	 * @param teacherRef String
	 * @param firstName String
	 * @param lastName String
	 * @param age Integer
	 * @param gender String
	 * @param schoolRef String
	 * @param regRefs ArrayList<String>
	 */
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

	/**
	 * Method getTeacher.
	 * @return Teacher
	 */
	public Teacher getTeacher() {
		loadTeacher();
		return teacher;
	}

	public void loadTeacher() {
		teacher = DaoRepository.getTeachersDao().query(teacherRef);
	}

	/**
	 * Method setTeacher.
	 * @param teacher Teacher
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * Method getTeacherRef.
	 * @return String
	 */
	public String getTeacherRef() {
		return teacherRef;
	}

	/**
	 * Method setTeacherRef.
	 * @param teacherRef String
	 */
	public void setTeacherRef(String teacherRef) {
		Teacher oldTeacher = DaoRepository.getTeachersDao().query(
				this.teacherRef);
		Teacher newTeacher = DaoRepository.getTeachersDao().query(teacherRef);
		if (newTeacher != null) {
			if (oldTeacher != null)
				oldTeacher.unregisterDeletionObserver(this);
			newTeacher.registerDeletionObserver(this);
			this.teacherRef = teacherRef;
		}
	}

	/**
	 * Method getSchoolRef.
	 * @return String
	 */
	public String getSchoolRef() {
		return schoolRef;
	}

	/**
	 * Method setSchoolRef.
	 * @param schoolRef String
	 */
	public void setSchoolRef(String schoolRef) {
		School oldSchool = DaoRepository.getSchoolsDao().query(this.schoolRef);
		School newSchool = DaoRepository.getSchoolsDao().query(schoolRef);
		if (newSchool != null) {
			if (oldSchool != null)
				oldSchool.unregisterDeletionObserver(this);
			newSchool.registerDeletionObserver(this);
			this.schoolRef = schoolRef;
		}
	}

	/**
	 * Method getRegRefs.
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getRegRefs() {
		return regRefs;
	}

	/**
	 * Method setRegRefs.
	 * @param regRefs ArrayList<String>
	 */
	public void setRegRefs(ArrayList<String> regRefs) {
		ArrayList<String> newRefs = new ArrayList<String>();
		newRefs.addAll(this.regRefs);
		for (String ref : newRefs)
			removeRegRef(ref);
		newRefs = regRefs;
		for (String ref : regRefs)
			addRegRef(ref);
	}

	public void addRegRef(String ref) {
		if (!this.regRefs.contains(ref))
			this.regRefs.add(ref);
		Registration r = DaoRepository.getRegistrationsDao().query(ref);
		if (r != null)
			r.registerDeletionObserver(this);
	}

	public void removeRegRef(String ref) {
		this.regRefs.remove(ref);
		Registration r = DaoRepository.getRegistrationsDao().query(ref);
		if (r != null)
			r.unregisterDeletionObserver(this);
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
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @param gender the gender to set
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
		school = DaoRepository.getSchoolsDao().query(schoolRef);
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
			registrations.add(DaoRepository.getRegistrationsDao().query(ref));
	}

	/**
	 * @param groupLeader the groupLeader to set
	 */
	public void setGroupLeader(Teacher groupLeader) {
		this.teacher = groupLeader;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * @param registrations the registrations to set
	 */
	public void setRegistrations(ArrayList<Registration> registrations) {
		this.registrations = registrations;
	}

	/**
	 * Method compareTo.
	 * @param o Athlete
	 * @return int
	 */
	@Override
	public int compareTo(Athlete o) {
		int retVal = 0;
		retVal = this.getLastName().compareTo(o.getLastName());
		if (retVal == 0)
			retVal = this.getFirstName().compareTo(o.getFirstName());
		return retVal;
	}

	@Override
	public void deleteReference(DeletionSubject subject) {
		if (subject instanceof Registration) {
			Registration reg = (Registration) subject;
			removeRegRef(reg.getDbId());

			MaintainAthleteController mac = new MaintainAthleteController();
			mac.saveAthlete(this);
		} else if (subject instanceof School) {
			// Deleted last reference to School,
			// so Athlete should also be deleted
			MaintainAthleteController mac = new MaintainAthleteController();
			mac.deleteAthlete(this);
		} else if (subject instanceof Teacher) {
			// Deleted last reference to Teacher,
			// so Athlete should also be deleted
			MaintainAthleteController mac = new MaintainAthleteController();
			mac.deleteAthlete(this);
		}
	}

	@Override
	public void runHooks() {
		ArrayList<String> refs = new ArrayList<String>();
		refs.addAll(getRegRefs());
		setRegRefs(refs);

		setSchoolRef(getSchoolRef());
		setTeacherRef(getTeacherRef());
	}
}
