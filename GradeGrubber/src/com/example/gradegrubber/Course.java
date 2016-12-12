package com.example.gradegrubber;

import java.util.ArrayList;
import android.widget.EditText;

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
	
	public void addAssignment(Assignment newAssign) {
		Assignments.add(newAssign);
		
	}

	public void deleteAssingment(int tappedposition) {
		Assignments.remove(tappedposition);
		
	}

	public void updateAssingment(int tappedposition, String assingmentName, double pointsAchieved, double maxPoints) {
		Assignments.set(tappedposition, new Assignment(assingmentName, pointsAchieved, maxPoints));
		
	}
	

}
