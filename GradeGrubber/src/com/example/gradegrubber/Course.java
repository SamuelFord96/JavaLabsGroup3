package com.example.gradegrubber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.gradegrubber.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;



public class Course extends Activity implements OnClickListener {
	private String courseName;
	private List<Assignment> myAssignments;
	private int tappedposition = -1;
	ArrayAdapter<Assignment> adapter;
	Assignment assingment;
	
	//Declare button
	Button buttonAddAssignment;
	//Declare Edit Texts
	EditText maxPoints, pointsAchieved, addAssingmentName;
	//Declare Text views
	TextView classGrade, tvCourseTitle;
	//Declare List View
	ListView lstAssignmentType1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		
		buttonAddAssignment = (Button) findViewById(R.id.buttonAddAssingment);
		//Set their value
		maxPoints = (EditText) findViewById(R.id.maxPoints);
		pointsAchieved = (EditText) findViewById(R.id.pointsAchieved);
		addAssingmentName = (EditText) findViewById(R.id.addAssingmentName);
		//Set their values
		classGrade = (TextView) findViewById(R.id.classGrade);
		tvCourseTitle = (TextView) findViewById(R.id.tvCourseTitle);
		//Set their value
		lstAssignmentType1 = (ListView) findViewById(R.id.lstAssignmentType1);
		
		buttonAddAssignment.setOnClickListener(this);
		
	}
	
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.buttonAddAssingment:
			double pointsAchievedDouble = Double.parseDouble(pointsAchieved.getText().toString());
			double maxPointsDouble = Double.parseDouble(maxPoints.getText().toString());
			Assignment newAssignment = new Assignment(addAssingmentName.getText().toString(), pointsAchievedDouble, maxPointsDouble);
		// If add button was clicked use transactions.add to add to a transaction
			if (buttonAddAssignment.getText().equals("Add")){
				assingment.addAssignment(newAssignment);
			}
		}
	}
	
	
	/**
	 * @param courseName
	 * @param myAssignments
	 */
	public Course(String courseName) {
		super();
		this.courseName = courseName;
		this.myAssignments = new ArrayList<Assignment>();
	}
	public void addAssignment(){
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.course, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
	
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}