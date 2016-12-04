package com.mis4800.group3.checkbook_android;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
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

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener {
	// Identifies Buttons, Views, EditTexts, and Adapters used within the scope of this Class
	Button btnAdd, btnDelete;
	TextView tvBalance;
	ListView lstTransactions;
EditText txtAmount;
	
	ArrayAdapter<Double> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Assign our buttons, Views etc. a value based upon their Id
		tvBalance = (TextView) findViewById(R.id.tvBalance);
		txtAmount = (EditText) findViewById(R.id.txtAmount);
		
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		//Use OnClickListener to Listen for user input
		btnAdd.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		
		lstTransactions = (ListView) findViewById(R.id.lstTransactions);
		// Assigns array to our array adapter
		adapter = new ArrayAdapter<Double>(this, android.R.layout.simple_list_item_1,
				transactions);	
		lstTransactions.setAdapter(adapter);
		//OnItemClickListener to listen for user inputs specific items within ListView
		lstTransactions.setOnItemClickListener(this);
	}
		
		private int tappedposition = -1;
		//Create an array of transactions
			List<Double> transactions = new ArrayList<Double>();

			/**
			 * Calculate the current balance
			 * Return the current balance
			 */

			private double calculateBalance() {
				//set beginning balance to 0
				double balance = 0.0;
				// Use a for each loop to count all transactions
				for(Double thisTransaction: transactions) {
					//Add each transaction to the current balance
					balance = balance + thisTransaction;
				}
				
				System.out.println("Current Balance is " + balance );
				// return the calculated balance
				return balance;
			}
			
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
		//Use switch statement to solve for which button was clicked
		switch (v.getId()){
		case R.id.btnAdd:
			// Set it so that if Edit Text box is empty the app doesn't crash
			if (txtAmount.getText().toString().equals("")) {return;
			//parse into double from string
			}else { double amount = Double.parseDouble(txtAmount.getText().toString());
			// If add button was clicked use transactions.add to add to a transaction
				if (btnAdd.getText().equals("Add")){
					transactions.add(amount);
					// Else update the amount using transactions.set
					} else {
						transactions.set(tappedposition, amount);
						
					
			}
			}
			
			break;
		case R.id.btnDelete:
			/*If tapped position has already been deleted then make delete button do nothing instead
			 * of crashing
			 */
			if(tappedposition < 0) return;
			//Delete tapped position using transactions.remove
			transactions.remove(tappedposition);
			
			
			break;
		}
		//notify adapter to update display
		adapter.notifyDataSetChanged();
		//set tapped position back to -1
		tappedposition = -1;
		// create variable dollars to represent calculateBalance
		double dollars = calculateBalance();
		// Change the format to be currency
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		//Changes color based upon whether you have a positive balance, a 0 balance, or a negative balance
		if (calculateBalance() < 0){
			tvBalance.setTextColor(Color.RED);
			} else if (calculateBalance() == 0){
				tvBalance.setTextColor(Color.rgb(255,102,0));
			} else if(calculateBalance() > 0){
				tvBalance.setTextColor(Color.GREEN);
		}
		//Update the balance after change in transactions and implement format change
		tvBalance.setText("Current balance is " + formatter.format(dollars));
		//Clear EditText after transaction
		txtAmount.setText("");
		//Set Delete button to be invisible after you delete or update a transaction
		btnDelete.setVisibility(android.view.View.INVISIBLE);
		//Turn button back to saying "Add"
		btnAdd.setText("Add");	
	}

	@Override
	public void onItemClick(AdapterView<?> listview, View itemview, int itemposition, long itemId) {
		// Copy the data from the current position to the EditText
		txtAmount.setText(transactions.get(itemposition).toString());
		// Change the button so the user knows we are updating
		btnAdd.setText("Update");
		//save the item position so the update can work
		tappedposition = itemposition;
		//Set delete button to be visible after item has been selected
		btnDelete.setVisibility(android.view.View.VISIBLE);
		
		
	}
	
}
