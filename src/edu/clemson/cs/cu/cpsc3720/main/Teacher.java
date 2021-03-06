package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;
import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * <h1>Teacher</h1>
 * <p>
 * Main Teacher class that holds information regarding a single teacher.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public class Teacher extends DatabaseObject implements Comparable<Teacher> {

	private String firstName;
	private String lastName;
	private String groupCode;

	/**
	 * Constructor for Teacher.
	 * @param firstName String
	 * @param lastName String
	 * @param groupCode String
	 */
	public Teacher(String firstName, String lastName, String groupCode) {
		super();
		this.groupCode = groupCode;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return this.groupCode;
	}

	/**
	 * @param groupCode the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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
	 * Method toString. @return String
	 */
	@Override
	public String toString() {
		String retVal = "";
		retVal = getLastName() + ", " + getFirstName();
		if (retVal.trim().equals(","))
			retVal = "";
		return retVal;
	}

	/**
	 * Method compareTo.
	 * @param t Teacher @return int
	 */
	@Override
	public int compareTo(Teacher t) {
		int retVal = 0;
		retVal = this.lastName.compareTo(t.getLastName());
		return retVal;
	}

	/**
	 * Method equals.
	 * @param o Object @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof Teacher) {
			Teacher t = (Teacher) o;
			if (this.toString().equals(t.toString()))
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

	/**
	 * Method copy.
	 * @param o DatabaseSerializable
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#copy(DatabaseSerializable)
	 */
	@Override
	public void copy(DatabaseSerializable o) {
		if (o instanceof Teacher) {
			Teacher t = (Teacher) o;

			this.setFirstName(t.getFirstName());
			this.setLastName(t.getLastName());
			this.setGroupCode(t.getGroupCode());
		}
	}
}
