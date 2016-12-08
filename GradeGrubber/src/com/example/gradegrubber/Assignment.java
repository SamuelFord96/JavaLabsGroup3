package com.example.gradegrubber;

import java.util.ArrayList;
import java.util.List;


/* This is a class that we will use to keep track of all the assingments that students add, as well as the points that each assingment has
 * 	then we will funnel all that data into the course activity to be displayed
 * 
 */
public class Assignment {
	private String assignmentName;
	private double scoreAchieved;
	private double maxPoints;
	// private double extraCredit; FIXME May not add in 
	
	/**
	 * @param assignmentName
	 * @param scoreAchieved
	 * @param maxPoints
	 */
	public Assignment(String assignmentName, double scoreAchieved, double maxPoints) {
		super();
		this.assignmentName = assignmentName;
		this.scoreAchieved = scoreAchieved;
		this.maxPoints = maxPoints;
		// this.extraCredit = extraCredit; FIXME may not add this in		
	}
	
	
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		assignmentName = assignmentName;
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

}
