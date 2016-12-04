package com.mis4800.group3.checkbook_android.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction {
	private Date tdate;
	private String payee;
	private Double amount;
	private String memo;
	
	private static SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
	public static NumberFormat currencyformat = NumberFormat.getCurrencyInstance(Locale.getDefault());
	/**
	 * @param tdate
	 * @param payee
	 * @param amount
	 * @param memo
	 */
	public Transaction(Date tdate, String payee, Double amount, String memo) {
		super();
		this.tdate = tdate;
		this.payee = payee;
		this.amount = amount;
		this.memo = memo;
	}

	/**
	 * @return the tdate
	 */
	public Date getTdate() {
		return tdate;
	}

	/**
	 * @param tdate the tdate to set
	 */
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Amount: " + getFormattedAmount() + "\nPayee: " + payee + "\nMemo: " + memo + "\nDate: " + getFormattedDate()
				;
	}

	/**
	 * @return the payee
	 */
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getFormattedDate() {
		return dateformat.format(tdate);
	
	}
	public String getFormattedAmount() {
		return currencyformat.format(amount);
	}
	
	public int compareByDate(Transaction another){
		return tdate.compareTo(another.getTdate());
	}
	
	public int compareByAmount(Transaction another){
		return amount.compareTo(another.getAmount());
	}
	
	

}
