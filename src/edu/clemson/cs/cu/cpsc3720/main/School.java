package edu.clemson.cs.cu.cpsc3720.main;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DeletionSubject;

/**
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 */
public class School extends DatabaseObject implements Comparable<School> {

	private String schoolName;

	/**
	 * Constructor for School.
	 * @param schoolName String
	 */
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
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * Method toString. @return String
	 */
	@Override
	public String toString() {
		String retVal = "";
		retVal = this.getSchoolName().trim();
		return retVal;
	}

	/**
	 * Method compareTo.
	 * @param o School @return int
	 */
	@Override
	public int compareTo(School o) {
		int retVal = 0;
		retVal = this.schoolName.compareTo(o.schoolName);
		return retVal;
	}

	/**
	 * Method equals.
	 * @param o Object @return boolean
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

}
