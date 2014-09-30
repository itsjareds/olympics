package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class School implements DatabaseSerializable {

	private transient String dbId;
	private String schoolName;

	public School(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return this.schoolName;
	}

	/**
	 * @param schoolName
	 *            the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String getDbId() {
		return this.dbId;
	}

	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

}
