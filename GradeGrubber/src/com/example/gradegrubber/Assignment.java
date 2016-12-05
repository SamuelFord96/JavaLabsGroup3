package com.example.gradegrubber;

import java.util.ArrayList;

/* This is a class that we will use to keep track of all the assingments that students add, as well as the points that each assingment has
 * 	then we will funnel all that data into the course activity to be displayed
 * 
 */
public class Assignment {
	private String AssignmentName;
	private double scoreAchieved;
	private double maxPoints;
	private double extraCredit;
	private ArrayList<Assignment> Assignment; 
	/**
	 * @param assignmentName
	 * @param scoreAchieved
	 * @param maxPoints
	 */
	public Assignment(String assignmentName, double scoreAchieved, double maxPoints) {
		super();
		AssignmentName = assignmentName;
		this.scoreAchieved = scoreAchieved;
		this.maxPoints = maxPoints;
		this.extraCredit = extraCredit;
		this.Assignment = new ArrayList<Assignment>();
		
	}
	public String getAssignmentName() {
		return AssignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		AssignmentName = assignmentName;
	}
	public double getScoreAchieved() {
		return scoreAchieved;
	}
	public void setScoreAchieved(double scoreAchieved) {
		this.scoreAchieved = scoreAchieved;
	}
	public double getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(double maxPoints) {
		this.maxPoints = maxPoints;
	}
	
	public double calculateGrade(double maxPoints, double scoreAchieved, double extraCredit){
		return (scoreAchieved + extraCredit)/maxPoints;
		
	}
	public void addAssignment(Assignment newAssign) {
		Assignment.add(newAssign);
		
	}

}
