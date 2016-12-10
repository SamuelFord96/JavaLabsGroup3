/**
 * 
 */
package com.example.gradegrubber;

/**
 * @author Sam
 *
 */
public class QuickNotes {
private String textBody;

/**
 * @return the textBody
 */
public String getTextBody() {
	return textBody;
}

/**
 * @param textBody the textBody to set
 */
public void setTextBody(String textBody) {
	this.textBody = textBody;
}

/**
 * @param textBody
 */
public QuickNotes(String textBody) {
	super();
	this.textBody = textBody;
}

public String toString(){
	return textBody;
}
}
