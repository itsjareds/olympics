package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.clemson.cs.cu.cpsc3720.controllers.MaintainAthleteController;
import edu.clemson.cs.cu.cpsc3720.databaseaccess.DaoRepository;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;
import edu.clemson.cs.cu.cpsc3720.validators.DatabaseObjectValidator.InvalidObjectException;

/**
 * <h1>Athlete</h1>
 * <p>
 * Main Athlete class that holds database references to a Teach, a school, and a
 * registration. Stores the information of a single athlete.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
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

	public Athlete() {
		super();
	}

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
		// Remove old listeners when new references set
		if (this.regRefs == null)
			this.regRefs = new ArrayList<String>();
		if (regRefs == null)
			regRefs = new ArrayList<String>();
		ArrayList<String> newRefs = new ArrayList<String>();
		newRefs.addAll(this.regRefs);
		for (String ref : newRefs)
			removeRegRef(ref);
		newRefs = regRefs;

		for (String ref : regRefs)
			addRegRef(ref);
	}

	/**
	 * Method addRegRef.
	 * @param ref String
	 */
	public void addRegRef(String ref) {
		if (!this.regRefs.contains(ref))
			this.regRefs.add(ref);
		Registration r = DaoRepository.getRegistrationsDao().query(ref);
		if (r != null)
			r.registerDeletionObserver(this);
	}

	/**
	 * Method removeRegRef.
	 * @param ref String
	 */
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
		if (regRefs == null)
			regRefs = new ArrayList<String>();
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

	/**
	 * Method deleteReference.
	 * @param subject DeletionSubject
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver#deleteReference(DeletionSubject)
	 */
	@Override
	public void deleteReference(DeletionSubject subject) {
		if (subject instanceof Registration) {
			Registration reg = (Registration) subject;
			unregisterDeletionObserver(reg);
			removeRegRef(reg.getDbId());

			MaintainAthleteController mac = new MaintainAthleteController();
			try {
				// saving existing athlete with updated references
				mac.saveAthlete(this);
			} catch (InvalidObjectException e) {
				JOptionPane.showMessageDialog(null,
						"Error deleting reference: " + e.getMessage());
			}
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

	/**
	 * Method runHooks.
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionObserver#runHooks()
	 */
	@Override
	public void runHooks() {
		ArrayList<String> refs = new ArrayList<String>();
		refs.addAll(getRegRefs());
		setRegRefs(refs);

		setSchoolRef(getSchoolRef());
		setTeacherRef(getTeacherRef());
	}

	@Override
	public void copy(DatabaseSerializable o) {
		if (o instanceof Athlete) {
			Athlete a = (Athlete) o;

			this.setTeacherRef(a.getTeacherRef());
			this.setFirstName(a.getFirstName());
			this.setLastName(a.getLastName());
			this.setAge(a.getAge());
			this.setGender(a.getGender());
			this.setSchoolRef(a.getSchoolRef());
			this.setRegRefs(a.getRegRefs());
		}
	}
}
