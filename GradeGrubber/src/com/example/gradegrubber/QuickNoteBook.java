/**
 * 
 */
package com.example.gradegrubber;

import java.util.ArrayList;

/**
 * @author Sam
 *
 */
public class QuickNoteBook {
public ArrayList<QuickNotes> Notes;

/**
 * 
 */
public QuickNoteBook() {
	super();
	this.Notes = new ArrayList<QuickNotes>();
}
public void AddNote(QuickNotes NewN){
	Notes.add(NewN);
}
/**
 * @return the notes
 */
public ArrayList<QuickNotes> getNotes() {
	return Notes;
}

/**
 * @param notes the notes to set
 */
public void setNotes(ArrayList<QuickNotes> notes) {
	Notes = notes;
}
public void deleteNotes(int tappedposition) {
	Notes.remove(tappedposition);
}
public void updateNotes(int tappedposition, String note) {
	Notes.set(tappedposition, new QuickNotes(note));
	
}
}
