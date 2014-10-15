package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Teacher implements DatabaseSerializable, Comparable<Teacher> {

	private transient String dbId;
	private String firstName;
	private String lastName;
	private String groupCode;

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
	 * @param groupCode
	 *            the groupCode to set
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

	@Override
	public String getDbId() {
		return this.dbId;
	}

	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

	@Override
	public String toString() {
		String retVal = "";
		retVal = getLastName() + ", " + getFirstName();
		if (retVal.trim().equals(","))
			retVal = "";
		return retVal;
	}

	@Override
	public int compareTo(Teacher t) {
		int retVal = 0;
		retVal = this.lastName.compareTo(t.getLastName());
		return retVal;
	}

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
}
