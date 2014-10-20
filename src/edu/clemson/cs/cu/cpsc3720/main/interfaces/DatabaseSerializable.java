package edu.clemson.cs.cu.cpsc3720.main.interfaces;

/**
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

	/*
	 * This method is necessary because Gson doesn't allow for initialization
	 * blocks. Gson will leave instance fields uninitialized. Call this method
	 * whenever you deserialize using Gson.
	 */
	public void initialize();
}
