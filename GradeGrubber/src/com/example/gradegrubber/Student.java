/**
 * 
 */
package com.example.gradegrubber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam
 *
 */
public class Student {
	private String myName;
	private List<Course> myCourses;
	/**
	 * @param myName
	 */
	public Student(String myName) {
		super();
		myName = myName;
		this.myCourses = new ArrayList<Course>();
	}
	public void addCourse(Course newCourse){
		myCourses.add(newCourse);
	}
	public void deleteCourse(int positionOfCourse){
		myCourses.remove(positionOfCourse);
	}
	public void updateCourse(int positionOfCourse, Course newCourse){
		myCourses.set(positionOfCourse, newCourse);
	}
	/**
	 * @return the myName
	 */
	public String getMyName() {
		return myName;
	}
	/**
	 * @param myName the myName to set
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}
	/**
	 * @return the myCourses
	 */
	public List<Course> getMyCourses() {
		return myCourses;
	}
				
	}

}
