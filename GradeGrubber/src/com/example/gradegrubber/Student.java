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
	
}
