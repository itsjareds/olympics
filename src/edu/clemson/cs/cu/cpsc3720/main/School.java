package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

/**
 */
public class School implements DatabaseSerializable, Comparable<School> {

	private transient String dbId;
	private String schoolName;

	/**
	 * Constructor for School.
	 * @param schoolName String
	 */
	public School(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	
	 * @return the schoolName */
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

	/**
	 * Method getDbId.
	 * @return String
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#getDbId()
	 */
	@Override
	public String getDbId() {
		return this.dbId;
	}

	/**
	 * Method setDbId.
	 * @param id String
	 * @see edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable#setDbId(String)
	 */
	@Override
	public void setDbId(String id) {
		this.dbId = id;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		String retVal = "";
		retVal = this.getSchoolName().trim();
		return retVal;
	}

	/**
	 * Method compareTo.
	 * @param o School
	 * @return int
	 */
	@Override
	public int compareTo(School o) {
		int retVal = 0;
		retVal = this.schoolName.compareTo(o.schoolName);
		return retVal;
	}

	/**
	 * Method equals.
	 * @param o Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof School) {
			School s = (School) o;
			if (this.toString().equals(s.toString()))
				retVal = true;
		}
		return retVal;
	}

}
