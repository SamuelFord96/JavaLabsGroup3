package com.example.gradegrubber;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener, OnItemLongClickListener, Serializable{
	Button btnAddCourse, btnDeleteCourse, btnToNotes, btnUpdateCourse;
	TextView tvTitleGrubberHubber, tvYourCourses;
	EditText txtAddCourseName;
	ListView lstYourCourses;
	
	ArrayAdapter<Course> courseAdapter;
	Student myself;
	public static Course currentCourse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		myself = new Student("Whoever");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvTitleGrubberHubber = (TextView) findViewById(R.id.tvTitleGrubberHubber);
		tvYourCourses = (TextView) findViewById(R.id.tvYourCourses);
		
		txtAddCourseName = (EditText) findViewById(R.id.txtAddCourseName);
		
		btnAddCourse = (Button) findViewById(R.id.btnAddCourse);
		btnToNotes = (Button) findViewById(R.id.btnToNotes);
		btnDeleteCourse = (Button) findViewById(R.id.btnDeleteCourse);
		btnUpdateCourse = (Button) findViewById(R.id.btnUpdateCourse);
		btnAddCourse.setOnClickListener(this);
		btnToNotes.setOnClickListener(this);
		
		
		lstYourCourses = (ListView) findViewById(R.id.lstYourCourses);
		courseAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1,
				myself.getCourses());
		lstYourCourses.setAdapter(courseAdapter);
		
		//btnAddCourse.setOnClickListener(this);
		lstYourCourses.setOnItemClickListener(this);
		lstYourCourses.setOnItemLongClickListener(this);
		
	}
	private int tappedposition = -1;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btnAddCourse:
			Course newCourse = new Course(txtAddCourseName.getText().toString());
			myself.addCourse(newCourse);
			break;
		case R.id.btnToNotes:
			Intent toNotes = new Intent(MainActivity.this, NoteActivity.class);
			startActivity (toNotes);
			break;
		}
		courseAdapter.notifyDataSetChanged();
	}
	
	// FIXME Doesnt work quite yet. Not sure why. but, no crashing
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Course curcourse = myself.getCourses().get(position);
		txtAddCourseName.setText(curcourse.getCname().toString());
		tappedposition = position;
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> listview, View itemview, int itemposition, long itemid) {
		// TODO Auto-generated method stub
		Course curcourse = myself.getCourses().get(itemposition);
		tappedposition = itemposition;
		Intent courseActivity = new Intent(MainActivity.this, CourseActivity.class);
		courseActivity.putExtra("CourseName", curcourse.getCname());
		currentCourse = curcourse;
		//courseActivity.putExtra("AssignmentList", curcourse.getAssignments());
		startActivity (courseActivity);
	}
}
