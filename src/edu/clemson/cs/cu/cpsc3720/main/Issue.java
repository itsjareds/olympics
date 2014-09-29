package edu.clemson.cs.cu.cpsc3720.main;

public class Issue {

	private String iD;
	private String title;
	private String description;
	private String status;

	public Issue(String iD, String title, String description, String status) {
		this.iD = iD;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
