package com.example.gradegrubber;

import java.util.ArrayList;

public class Course {

	
	public ArrayList<Assignment> getAssignments() {
		return Assignments;
	}
	
	public ArrayList<Assignment> Assignments; 
	
	
	private String cname;

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @param cname
	 */
	public Course(String cname) {
		super();
		this.cname = cname;
		this.Assignments = new ArrayList<Assignment>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return cname;
	}
	
	/**
	 * @param newAssign
	 */
	// adds an assignment to the assignment array
	public void addAssignment(Assignment newAssign) {
		Assignments.add(newAssign);
		
	}
	
	/**
	 * @param tappedposition
	 */
	// deletes assignment from the assignment array
	public void deleteAssingment(int tappedposition) {
		Assignments.remove(tappedposition);
	}
	
	/**
	 * @param tappedposition
	 * @param assingmentName
	 * @param pointsAchieved
	 * @param maxPoints
	 */
	//updates assignment form the assignment array by replacing tapped position with a new assignment
	public void updateAssingment(int tappedposition, String assingmentName, double pointsAchieved, double maxPoints) {
		Assignments.set(tappedposition, new Assignment(assingmentName, pointsAchieved, maxPoints));
		
	}
	

}
