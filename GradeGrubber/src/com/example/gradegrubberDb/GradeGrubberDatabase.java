
package com.example.gradegrubberDb;

import com.example.gradegrubber.Assignment;
import com.example.gradegrubber.Course;
import com.example.gradegrubber.QuickNoteBook;
import com.example.gradegrubber.QuickNotes;
import com.example.gradegrubber.Student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class GradeGrubberDatabase extends SQLiteOpenHelper {
	public static final String DBNAME = "GradeGrubber";
	public static final int version = 1;
	SQLiteDatabase mydatabase;
	//Need to be able to store the ArrayList
	private final String CREATESQLSTUDENT = "create table student(_id integer primary key, cname varchar(100));";
	private final String CREATESQLCOURSE = "create table course(_id integer primary key, assignmentName varchar(100), scoreAchieved double, maxPoints double);";
	private final String CREATESQLNOTE = "create table notes(id_integer primary key, textBody varchar(100));";
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATESQLSTUDENT);
		db.execSQL(CREATESQLCOURSE);
		db.execSQL(CREATESQLNOTE);

	}
	public void saveStudent(Student myself){
		mydatabase.delete("student", null, null);
		ContentValues cv = new ContentValues();
		for(Course c: myself.getCourses()){
			cv.put("cname", c.getCname());
			
			mydatabase.insert("student", null, cv);
		}
	}
	public void saveCourses(Course course1){
		ContentValues cv1 = new ContentValues();
		mydatabase.delete("course", null, null);
		
		for(Assignment a : course1.getAssignments()){
		
		cv1.put("assignmentName", a.getAssignmentName());
		cv1.put("scoreAchieved", a.getScoreAchieved());
		cv1.put("maxPoints", a.getMaxPoints());
		mydatabase.insert("course", null, cv1);
		}
	}
	public void saveNotes(QuickNoteBook myNotebook){
		ContentValues cv2 = new ContentValues();
		mydatabase.delete("notes", null, null);
		for(QuickNotes q : myNotebook.getNotes()){
			cv2.put("textBody", q.getTextBody());
			mydatabase.insert("notes", null, cv2);
		}
	}
	public void retrieveStudent(Student myself){
		myself.getCourses().clear();
		
		Cursor c = mydatabase.rawQuery("select * from student", null);
		while(c.moveToNext()){
			myself.addCourse(new Course(c.getString(1)));
		}
		c.close();
	}
	public void retrieveCourses(Course course1){
		course1.getAssignments().clear();
		
		Cursor c1 = mydatabase.rawQuery("select * from course", null);
		while(c1.moveToNext()){
			course1.addAssignment(new Assignment(c1.getString(1), c1.getDouble(2), c1.getDouble(3)));
			
		}
		c1.close();
	}
	public void retrieveNotes(QuickNoteBook myNoteBook){
		myNoteBook.getNotes().clear();
		
		Cursor c2 = mydatabase.rawQuery("select * from notes", null);
		while(c2.moveToNext()){
			myNoteBook.AddNote(new QuickNotes(c2.getString(1)));
		}
		c2.close();
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public GradeGrubberDatabase(Context context) {
		super(context, DBNAME, null, version);
		mydatabase = getWritableDatabase();
		// TODO Auto-generated constructor stub
	}

}
