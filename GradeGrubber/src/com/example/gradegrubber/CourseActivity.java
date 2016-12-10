package com.example.gradegrubber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.gradegrubber.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;



public class CourseActivity extends Activity implements OnClickListener, OnItemClickListener {
	private String courseName;
	private int tappedposition = -1;
	
	ArrayAdapter<Assignment> assignmentAdapter;
	//Course courseClicked;
	Course course1;
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
		Intent sourceIntent = getIntent();
		course1 = MainActivity.currentCourse;
		//courseName = sourceIntent.getStringExtra("CourseName");
		//this.myAssignments = new ArrayList<Assignment>();
		
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
		assignmentAdapter = new ArrayAdapter<Assignment>(this, android.R.layout.simple_list_item_2, course1.getAssignments());
		lstAssignmentType1.setOnItemClickListener(this);
		//course1.getAssignment());
		buttonAddAssignment.setOnClickListener(this);
		tvCourseTitle.setText(course1.getCname());
	}
	
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.buttonAddAssingment:
			double pointsAchievedDouble = Double.parseDouble(pointsAchieved.getText().toString());
			double maxPointsDouble = Double.parseDouble(maxPoints.getText().toString());
			Assignment newAssignment = new Assignment(addAssingmentName.getText().toString(), pointsAchievedDouble, maxPointsDouble);
		// If add button was clicked use transactions.add to add to a transaction
			// (buttonAddAssignment.getText().equals("Add")){
				course1.addAssignment(newAssignment);
				
			}
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

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
}