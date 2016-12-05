package com.example.gradegrubber;

import android.app.Activity;
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

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener{
	Button btnAddCourse, btnDeleteCourse;
	TextView tvTitleGrubberHubber, tvYourCourses;
	EditText txtAddCourseName;
	ListView lstYourCourses;
	
	ArrayAdapter<Course> courseAdapter;
	Student myself;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		myself = new Student("Whoever");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvTitleGrubberHubber = (TextView) findViewById(R.id.tvTitleGrubberHubber);
		tvYourCourses = (TextView) findViewById(R.id.tvYourCourses);
		
		txtAddCourseName = (EditText) findViewById(R.id.txtAddCourseName);
		
		btnAddCourse = (Button) findViewById(R.id.btnAddCourse);
		btnDeleteCourse = (Button) findViewById(R.id.btnDeleteCourse);
		
		lstYourCourses = (ListView) findViewById(R.id.lstYourCourses);
		courseAdapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1,
				myself.getCourses());
		lstYourCourses.setAdapter(courseAdapter);
		//btnAddCourse.setOnClickListener(this);
		lstYourCourses.setOnItemClickListener(this);
		
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
		case R.id.btnDeleteCourse:
			if(tappedposition < 0) return;
			myself.deleteCourse(tappedposition);
		}
		courseAdapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
	}
}
