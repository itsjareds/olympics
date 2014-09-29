package edu.clemson.cs.cu.cpsc3720.databaseaccess;

import edu.clemson.cs.cu.cpsc3720.main.Project;

public class DatabaseDriver {

	public static void main(String[] args) {
		DatabaseAccessObject<Project> projectDao = new DatabaseAccessObject<Project>();
		projectDao.load(Project.class);
		for (Project p : projectDao.objects) {
			System.out.println("Project " + p.getTitle() + " with "
					+ p.getIssues().size() + " issues");
		}
	}

}
