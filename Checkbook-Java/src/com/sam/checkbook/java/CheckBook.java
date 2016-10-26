package com.sam.checkbook.java;

public class CheckBook {
	//set up a MAX constant
	public static final int MAX = 7;
//Create an array of transactions
	double[] transactions = new double[MAX];
	
	int numTransactions = 0;
	public static void main(String[] args) {
		new CheckBook().test();
		// TODO Auto-generated method stub

	}

	private void test() {
		// TODO Auto-generated method stub
		addTransaction(100.0); // pos 0
		addTransaction(200.0); //pos 1
		addTransaction(-150.0);//pos 2
		addTransaction(1000.0);//pos 3
		addTransaction(-750.0);// pos 4
		addTransaction(-20.0);
		addTransaction(-100.0);
		
		calculateBalance();
		
		updateTransaction(4, -700.0);
		calculateBalance();
		deleteTransaction(4);
		calculateBalance();
	}

	private void deleteTransaction(int position) {
		// TODO Auto-generated method stub
		for(int emptyPosition = position; emptyPosition < numTransactions -1; emptyPosition++) {
			transactions[emptyPosition] = transactions[emptyPosition + 1];
		}
		numTransactions = numTransactions - 1;
	}

	private void updateTransaction(int position, double newAmount) {
		//chg transaction amount in position to new amount
		transactions[position] = newAmount;
		// TODO Auto-generated method stub
		
	}

	private void calculateBalance() {
		double balance = 0.0;
		// TODO Auto-generated method stub
		for(int i=0; i < numTransactions; i++) {
			balance = balance + transactions[i];
		}
		
		System.out.println("Current Balance is " + balance );
	}
		
	

	private void addTransaction(double amount) {
		// TODO Auto-generated method stub
		if (numTransactions < MAX) {
		//Put amount in the right position
		transactions[numTransactions] = amount;
		//increment the number of transactions
		numTransactions++ ;
		} else { System.out.println("Error Checkbook full");
		}
		}
}
		
	

