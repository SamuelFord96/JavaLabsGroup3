package com.w017sdf.assigment1;
//Experimental merging comment.
//Added a period
import com.jit.assignment1checker.Assignment1Tasks;
import com.jit.assignment1checker.Checker;

public class AssignmentOne implements Assignment1Tasks {

	public static void main(String[] args) {
		AssignmentOne myAssignment = new AssignmentOne();
		Checker.checkProfitMargin(myAssignment);
		Checker.checkGetGrade(myAssignment);
		Checker.checkSumOfDigits(myAssignment);
		Checker.checkMonthsSaved(myAssignment);
		Checker.checkFindAverage(myAssignment);
// Comment
		
		}
	
	/**
	 * This method finds the average age of any number of participant
	 * by adding all the ages and dividing them by them number of participants
	 */
		public double findAverageAge(int[] participantAges) {
		// Declare a variable for the number of participants and initialize it at 0
		int numOfParticipants = 0;
		//Declare a variable for the sum of the participants' ages and initialize it at 0
		double sumOfAges = 0;
		/* create a for loop and create a variable to act as an index. Next, Set the loop so that it ends after counting the
		 * last spot in the array. Next set it so that "i" increments by one after each repetition */
		for(int i=0; i<participantAges.length; i++) {
			// Add each element(age of participant) of the array to the sum of the ages.
		sumOfAges = sumOfAges + participantAges[i];
		//Count the total number of participants by adding one every time the loop repeats
		numOfParticipants++;
		}
		// Divide the total ages by the number of participants
		return sumOfAges / numOfParticipants ;
		}

		@Override
		/** This method calculates the correct grade of a student using the 90/80/70/60 scale
		 * It can calculate the grade for any max score and can include a curve or grace percentage*/
		public String getGrade(int maxScore, int studentScore, float gracePercent) {
		/*Solve to find the students score after it has received the gracePercent
		 * Adjust the "grace" to correct proportion by dividing it by a hundred then multiplying that by the max score
		 * then add this adjusted bonus to the student's score*/
		double curvedScore = studentScore + (maxScore *(gracePercent/100));
		// Divide the curved score by the max score to get a percentage correspondent with the proper 90/80/70/60 format
		double endScore = curvedScore / maxScore; 
		// compare the endscore to the percentages to correctly solve for grade. If it is greater than .9 it is an "A"
		if (endScore >= .9){
			return "A";}
		//If score is greater than .8 it is a "B" so on and so forth..
		else if(endScore >= .8){
			return "B";}
		else if(endScore >= .7){
			return "C";}
		else if(endScore >= .6){
			return "D";}
		//If it is not greater than .6 then the grade is an "F"
		else return "F";
		
		}
	
		

		/** This method shows how many months payments you would save if you paid an extra amount towards
		 * the principal each month. It will solve for any amount*/
		public int monthsSaved(float principal, float rate, int period, float monthlyExtraPrincipal) {
			// solve for "n" in the Mortgage P&I equation
			int n = period *12;
			//divide by 100 to make the rate a percentage and then divide by 12 to make it monthly
			double monthlyRate = rate / 100 / 12;
			//Solve for mortgage principle and interest
			double monthlyPayment = principal * monthlyRate / (1 - Math.pow(1+monthlyRate, -n));
			//Create a variable for current principal
			double currentPrincipal = principal;
			//create a variable for months saved and initialize it to 0
			int monthSaved = 0;
			/*create a for loop with the integer "month" starting at 1. Set the loop so that it ends when
			 * Current principal is not greater than 0. increment the integer month by one each repetition */
			for (int month = 1; currentPrincipal > 0 * 12; month++) {
			//Calculate the amount of monthly payment that goes towards interest
			double thisMonthInterest = monthlyRate * currentPrincipal;
			//calculate the amount of monthly payment that goes towards principal including the extra principal paid
			double thisMonthPrincipal = (monthlyPayment - thisMonthInterest) + monthlyExtraPrincipal;
			//update the new principal for each monthly payment
			currentPrincipal = currentPrincipal - (thisMonthPrincipal);
			//Calculate the amount of monthly payments saved by paying the extra amount towards principal
			monthSaved = (period*12) - month;}
			//Return the Months Saved
			return monthSaved;
		}

		/** This method solves for the profit in an equation with costs for goods and labor as well as accounting 
		 * for a discounted price*/
		public double profitMargin(double costOfGoods, double costOfLabor, double salesPrice, double discountPercent) {
		// Subtract the discount from the total percent, then multiply by the sales price to get the discounted sales price
		double discountedSalesPrice = (salesPrice * (1-(discountPercent/100)));
		//subtract your total costs from the discounted sales price to get your gross profit (profit margin)
		double grossProfit = (discountedSalesPrice - (costOfGoods + costOfLabor));
		//return gross profit (profit margin)
		return grossProfit;
		}

		/** This method solves for the sum of the digits of any number within the "int" range.
		 * The method uses a for loop to solve for the sum quickly*/
		public int sumOfDigits(int number) {
		// Declare sum variable and initialize at 0
		int sum = 0;
		/*Create a loop with int digitsCounted starting at 0. Set the loop so that it ends when the number equals 0.
		 * Increment digitsCounted by 1 each repetition. digitsCounted has no other current use than to start the loop,
		 * but it would be easy to implement it so that the method also tells you how many digits the number was */
		for (int digitsCounted =0; number > 0; digitsCounted++){
			// Add each digit to the sum of digits starting from the ones place
			sum = sum + (number % 10);
			/*Update the number so that the "ones" place is dropped after it is 
			 * counted and the "tens" column is the new "ones" column. 
			 */
			number = number / 10;
		}
		//Return the final sum
		return sum;
		}


		}
