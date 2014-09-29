package edu.clemson.cs.cu.cpsc3720.main;

import java.util.ArrayList;
import java.util.List;

import edu.clemson.cs.cu.cpsc3720.main.interfaces.DatabaseSerializable;

public class Project implements DatabaseSerializable {

	private transient String dbId;
	private List<Issue> issues;
	private String title;

	public Project(String title) {
		this.title = title;
		this.issues = new ArrayList<Issue>();
	}

	public String getDbId() {
		return this.dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void addIssue(Issue issue) {
		this.issues.add(issue);
	}

	public int getNumberOfIssues() {
		return this.issues.size();
	}

}
