package com.example.gradegrubber;

import  com.example.gradegrubber.R;
import com.example.gradegrubberDb.GradeGrubberDatabase;

import android.app.Activity;
import android.os.Bundle;
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

public class NoteActivity extends Activity implements OnClickListener, OnItemLongClickListener, OnItemClickListener {
	Button btnAddNote, btnDeleteNote, btnUpdateNote, btnUpdateNoteReal, btnCancel;
	TextView tvYourNotes;
	EditText txtAddNote;
	ListView lstNotes;
	ArrayAdapter<QuickNotes> noteAdapter;
	QuickNoteBook myNoteBook;
	GradeGrubberDatabase mydatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		myNoteBook = new QuickNoteBook();
		mydatabase = new GradeGrubberDatabase(this);
		tvYourNotes = (TextView) findViewById(R.id.tvYourNotes);
		txtAddNote = (EditText) findViewById(R.id.txtAddNote);
		btnAddNote = (Button) findViewById(R.id.btnAddNote);
		btnDeleteNote = (Button) findViewById(R.id.btnDeleteNote);
		btnUpdateNote = (Button) findViewById(R.id.btnUpdateNoteReal);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		lstNotes = (ListView) findViewById(R.id.lstNotes);
		noteAdapter = new ArrayAdapter<QuickNotes>(this, android.R.layout.simple_list_item_1, myNoteBook.getNotes());
		lstNotes.setAdapter(noteAdapter);
		
		btnAddNote.setOnClickListener(this);
		btnDeleteNote.setOnClickListener(this);
		btnUpdateNote.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		
		lstNotes.setOnItemClickListener(this);
		lstNotes.setOnItemLongClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		mydatabase.saveNotes(myNoteBook);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		mydatabase.retrieveNotes(myNoteBook);
		noteAdapter.notifyDataSetChanged();
	}

	private int tappedposition = -1;
	
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
			if (checkFields()) break;
			QuickNotes newNote = new QuickNotes(txtAddNote.getText().toString());
			myNoteBook.AddNote(newNote);
			clearText();
			break;
	
		case R.id.btnDeleteNote:
			if (checkFields()) break;
			if(tappedposition < 0) return;
			myNoteBook.deleteNotes(tappedposition);
			clearText();
			btnAddNote.setVisibility(android.view.View.VISIBLE);
			btnDeleteNote.setVisibility(android.view.View.INVISIBLE);
			btnCancel.setVisibility(android.view.View.INVISIBLE);
			break;
			
		case R.id.btnUpdateNoteReal:
			if (checkFields()) break;
			if(tappedposition < 0) return;
			myNoteBook.updateNotes(tappedposition,txtAddNote.getText().toString());
			clearText();
			btnAddNote.setVisibility(android.view.View.VISIBLE);
			btnUpdateNote.setVisibility(android.view.View.INVISIBLE);
		}
		noteAdapter.notifyDataSetChanged();
	}
	
	//clears the text in the text box
	private void clearText() {
		txtAddNote.setText("");
	}
	
	//boolean that checks to see if text box is empty
	private boolean checkFields(){
		if (txtAddNote.getText().toString().equals("")) {
			return true;
		}
		return false;
	}
	
	@Override
	// makes the list long clickable to delete each tiem
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		//gets note from position that was long clicked
		QuickNotes longNote = myNoteBook.getNotes().get(position);
		//puts the note in that position in the text box
		txtAddNote.setText(longNote.getTextBody().toString());
		tappedposition = position;
		//makes add invisible, makes sure update is still invisible and makes delete visible
		btnAddNote.setVisibility(android.view.View.INVISIBLE);
		btnUpdateNote.setVisibility(android.view.View.INVISIBLE);
		btnDeleteNote.setVisibility(android.view.View.VISIBLE);
		btnCancel.setVisibility(android.view.View.VISIBLE);
		return true;
	}

	@Override
	// makes item in the list view clickable to update the item
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		//gets the item from the clicked position
		QuickNotes shortNote = myNoteBook.getNotes().get(position);
		//sets the text in the clicked postiion to the text box
		txtAddNote.setText(shortNote.getTextBody().toString());
		tappedposition = position;
		//makes the add button invisible, makes sure the delete is invisible and the update is visible
		btnAddNote.setVisibility(android.view.View.INVISIBLE);
		btnUpdateNote.setVisibility(android.view.View.VISIBLE);
		btnDeleteNote.setVisibility(android.view.View.INVISIBLE);
		btnCancel.setVisibility(android.view.View.INVISIBLE);
	}

}
