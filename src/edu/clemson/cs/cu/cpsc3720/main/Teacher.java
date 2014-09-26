package edu.clemson.cs.cu.cpsc3720.main;

public class Teacher {

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
}
