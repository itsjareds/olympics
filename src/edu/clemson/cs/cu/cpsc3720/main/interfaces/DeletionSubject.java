package edu.clemson.cs.cu.cpsc3720.main.interfaces;

public interface DeletionSubject {
	public void registerDeletionObserver(DeletionObserver observer);

	public void unregisterDeletionObserver(DeletionObserver observer);

	public void notifyDelete();
}
