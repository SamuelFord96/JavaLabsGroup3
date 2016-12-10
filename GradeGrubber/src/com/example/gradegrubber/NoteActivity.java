package com.example.gradegrubber;

import java.util.ArrayList;

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

public class NoteActivity extends Activity implements OnClickListener {
	Button btnAddNote;
	TextView tvYourNotes;
	EditText txtAddNotes;
	ListView lstNotes;
	ArrayAdapter<QuickNotes> noteAdapter;
	QuickNoteBook myNoteBook;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myNoteBook = new QuickNoteBook();
		tvYourNotes = (TextView) findViewById(R.id.tvYourNotes);
		txtAddNotes = (EditText) findViewById(R.id.txtAddNote);
		btnAddNote = (Button) findViewById(R.id.btnAddNote);
		lstNotes = (ListView) findViewById(R.id.lstNotes);
		//btnAddNote.setOnClickListener(this);
		noteAdapter = new ArrayAdapter<QuickNotes>(this, android.R.layout.simple_list_item_1,
				myNoteBook.getNotes());
		//lstNotes.setAdapter(noteAdapter);
		setContentView(R.layout.activity_note);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.note, menu);
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
		switch (v.getId()){
		case R.id.btnAddNote:
			QuickNotes newNote = new QuickNotes(txtAddNotes.getText().toString());
			myNoteBook.AddNote(newNote);
			break;
		// TODO Auto-generated method stub
		
	}}
}
