package com.example.gradegrubber;

import com.example.gradegrubber.R;
//import com.example.gradegrubberDb.GradeGrubberDatabase;

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
	Course course;
	//Declare button
	Button buttonAddAssignment, btnUpdate, btnDelete;
	//Declare Edit Texts
	EditText maxPoints, pointsAchieved, addAssingmentName;
	//Declare Text views
	TextView tvCourseTitle;
	//Declare List View
	ListView lstAssignmentType1;
	//GradeGrubberDatabase mydatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		Intent sourceIntent = getIntent();
		course = MainActivity.currentCourse;
		//mydatabase = new GradeGrubberDatabase(this);
		//set declared buttons above to the find view by id, so theyre clickable
		buttonAddAssignment = (Button) findViewById(R.id.buttonAddAssingment);
		btnDelete = (Button) findViewById(R.id.btnDelete); 
		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		
		//set declared edit text above to the find view by id, so theyre able to take input
		maxPoints = (EditText) findViewById(R.id.maxPoints);
		pointsAchieved = (EditText) findViewById(R.id.pointsAchieved);
		addAssingmentName = (EditText) findViewById(R.id.addAssingmentName);
		
		//set declared text view above to the find view by id, so that is can be change to the course name
		tvCourseTitle = (TextView) findViewById(R.id.tvCourseTitle);
		
		//set declared list view above to the find view by id, so it can take input
		lstAssignmentType1 = (ListView) findViewById(R.id.lstAssignmentType1);
		
		//sets up the array adapter so that stuff can be placed into the array
		assignmentAdapter = new ArrayAdapter<Assignment>(this, android.R.layout.simple_list_item_1, course.getAssignments());
		
		//sets up listners so that each item can take input when they are pressed
		lstAssignmentType1.setOnItemClickListener(this);
		buttonAddAssignment.setOnClickListener(this);
		btnUpdate.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		
		// sets the Medium text a the top of the screen to the name of the course that was clicked
		tvCourseTitle.setText(course.getCname());
		
		//sets up the array adapter so that stuff can be placed into the list view
		lstAssignmentType1.setAdapter(assignmentAdapter);
		
		//makes all the text fields "" so that they can be checked to see if theyre blank, to avoid the activity crashing
		clearText();
	}
	//FIXME this database did not work correctly and saves the data from an assignment to each and every instance of Course.
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	/*@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mydatabase.saveCourses(course);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	/*@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mydatabase.retrieveCourses(course);
		assignmentAdapter.notifyDataSetChanged();
	}*/

	@Override
	// method that can make each button usable and tells the button what to do when pressed
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.buttonAddAssingment:
			//checks to see if fields are blank or not to avoid crash
			if (checkFields()) break;
			// parses the string into a double so that it can be used to calculate grade on assignment
			double pointsAchievedDouble = Double.parseDouble(pointsAchieved.getText().toString());
			double maxPointsDouble = Double.parseDouble(maxPoints.getText().toString());
			//creates a new assignment by sending each of the inputs into the assignment constructor in the assignment class
			Assignment newAssignment = new Assignment(addAssingmentName.getText().toString(), pointsAchievedDouble, maxPointsDouble);
				//puts the assignment into the assignment array
				course.addAssignment(newAssignment);
				//clears text
				clearText();
				break;
				
		case R.id.btnDelete:
			if (checkFields()) break;
			if(tappedposition < 0) return;
			
			course.deleteAssingment(tappedposition);
			clearText();
			reverseInvisibility();
			break;
			
		case R.id.btnUpdate:
			if (checkFields()) break;
			if(tappedposition < 0) return;
			
			course.updateAssingment(tappedposition,
										addAssingmentName.getText().toString(),
										Double.parseDouble(pointsAchieved.getText().toString()), 
										Double.parseDouble(maxPoints.getText().toString()));
			clearText();
			reverseInvisibility();	
			
			}
			
		
	}
	// method to clear text from each text box
	private void clearText() {
		addAssingmentName.setText("");
		pointsAchieved.setText("");
		maxPoints.setText("");		
		
	}
	//method to make the add button invisible and the deletee and update button visible
	private void setInvisibility(){
		buttonAddAssignment.setVisibility(android.view.View.INVISIBLE);
		btnDelete.setVisibility(android.view.View.VISIBLE);
		btnUpdate.setVisibility(android.view.View.VISIBLE);
	}
	// method to change back the delete and update buttons to invisible and make the add button visible
	private void reverseInvisibility(){
		buttonAddAssignment.setVisibility(android.view.View.VISIBLE);
		btnDelete.setVisibility(android.view.View.INVISIBLE);
		btnUpdate.setVisibility(android.view.View.INVISIBLE);
	}
	
	// boolean method that returns true when any fields are blank and false if the fields arent blank, to avoid crash
	private boolean checkFields(){
		if (pointsAchieved.getText().toString().equals("") || maxPoints.getText().toString().equals("") || addAssingmentName.getText().toString().equals("")) {
			return true;
		}
		return false;	
	}
	
	// on item click method that makes the list view items clickable and puts the values of the item positions back in their respective text boxes
	@Override
	public void onItemClick(AdapterView<?> listview, View itemview, int itemposition, long itemid) {
		
		Assignment assingment = course.getAssignments().get(itemposition);
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
