package com.example.gradegrubber;

import java.text.DecimalFormat;


/* This is a class that we will use to keep track of all the assingments that students add, as well as the points that each assingment has
 * 	then we will funnel all that data into the course activity to be displayed
 * 
 */
public class Assignment {
	//Member variables declared
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
	
	@Override
	// The toString for the Course Activity list view. Its got decimal formatting for 2 places and it also has paragraphs to make it look better
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.##");
		String formattedScore = df.format((scoreAchieved/maxPoints)*100);
		return assignmentName + "\n" + scoreAchieved + "/" + maxPoints + "\n" + formattedScore +"%";
	}
}
