package com.example.gradegrubber;

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
	Button buttonAddAssignment, btnUpdate, btnDelete;
	//Declare Edit Texts
	EditText maxPoints, pointsAchieved, addAssingmentName;
	//Declare Text views
	TextView tvCourseTitle;
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
		btnDelete = (Button) findViewById(R.id.btnDelete); 
		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		
		//Set their value
		maxPoints = (EditText) findViewById(R.id.maxPoints);
		pointsAchieved = (EditText) findViewById(R.id.pointsAchieved);
		addAssingmentName = (EditText) findViewById(R.id.addAssingmentName);
		
		tvCourseTitle = (TextView) findViewById(R.id.tvCourseTitle);
		
		//Set their value
		lstAssignmentType1 = (ListView) findViewById(R.id.lstAssignmentType1);
		assignmentAdapter = new ArrayAdapter<Assignment>(this, android.R.layout.simple_list_item_1, course1.getAssignments());
		lstAssignmentType1.setOnItemClickListener(this);
		
		//course1.getAssignment());
		buttonAddAssignment.setOnClickListener(this);
		btnUpdate.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		tvCourseTitle.setText(course1.getCname());
		lstAssignmentType1.setAdapter(assignmentAdapter);
		
		clearText();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.buttonAddAssingment:
			if (checkCAFields()) break;
			
			double pointsAchievedDouble = Double.parseDouble(pointsAchieved.getText().toString());
			double maxPointsDouble = Double.parseDouble(maxPoints.getText().toString());
			Assignment newAssignment = new Assignment(addAssingmentName.getText().toString(), pointsAchievedDouble, maxPointsDouble);
		// If add button was clicked use transactions.add to add to a transaction
			// (buttonAddAssignment.getText().equals("Add")){
				course1.addAssignment(newAssignment);
				clearText();
				break;
				
		case R.id.btnDelete:
			if (checkCAFields()) break;
			if(tappedposition < 0) return;
			
			course1.deleteAssingment(tappedposition);
			clearText();
			reverseInvisibility();
			break;
			
		case R.id.btnUpdate:
			if (checkCAFields()) break;
			if(tappedposition < 0) return;
			
			course1.updateAssingment(tappedposition,
										addAssingmentName.getText().toString(),
										Double.parseDouble(pointsAchieved.getText().toString()), 
										Double.parseDouble(maxPoints.getText().toString()));
			clearText();
			reverseInvisibility();
		
		//case R.id.btnUpdate:
			
			
			}
			
		
	}
	
	private void clearText() {
		addAssingmentName.setText("");
		pointsAchieved.setText("");
		maxPoints.setText("");		
		
	}
	
	private void setInvisibility(){
		buttonAddAssignment.setVisibility(android.view.View.INVISIBLE);
		btnDelete.setVisibility(android.view.View.VISIBLE);
		btnUpdate.setVisibility(android.view.View.VISIBLE);
	}
	
	private void reverseInvisibility(){
		buttonAddAssignment.setVisibility(android.view.View.VISIBLE);
		btnDelete.setVisibility(android.view.View.INVISIBLE);
		btnUpdate.setVisibility(android.view.View.INVISIBLE);
	}
	
	private boolean checkCAFields(){
		
		if (pointsAchieved.getText().toString().equals("") || maxPoints.getText().toString().equals("") || addAssingmentName.getText().toString().equals("")) {
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> listview, View itemview, int itemposition, long itemid) {
		// TODO Auto-generated method stub
		Assignment assingment = course1.getAssignments().get(itemposition);
		addAssingmentName.setText(assingment.getAssignmentName().toString());
		pointsAchieved.setText(String.valueOf(assingment.getScoreAchieved()));
		maxPoints.setText(String.valueOf(assingment.getMaxPoints()));
		tappedposition = itemposition;
		setInvisibility();
		
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
