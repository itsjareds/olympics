package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
 * <h1>Database Serializable Interface</h1>
 * <p>
 * Interface that gives classes access to the get database ID and set database
 * ID methods as well as initialize.
 * @author bbest
 * @author shiz
 * @author klinge2
 * @version $Revision: 1.0 $
 * @since 10/20/2014
 */
public interface DatabaseSerializable {
	/**
	 * Method getDbId.
	 * @return String
	 */
	public String getDbId();

	/**
	 * Method setDbId.
	 * @param id String
	 */
	public void setDbId(String id);

	/**
	 * Method initialize.
	 * <p>
	 * This method is necessary because Gson doesn't allow for initialization
	 * blocks. Gson will leave instance fields uninitialized. Call this method
	 * whenever you deserialize using Gson.
	 */
	public void initialize();

	/**
	 * Method copy.
	 * <p>
	 * This method copies all fields from the other DatabaseSerializable object.
	 * Subclasses must implement this method for their own fields.
	 * @param o DatabaseSerializable
	 */
	public void copy(DatabaseSerializable o);
}
