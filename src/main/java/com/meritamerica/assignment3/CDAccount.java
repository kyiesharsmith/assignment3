package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class CDAccount extends BankAccount {
		private static CDOffering offering;
		private java.util.Date startDate;
		
		CDAccount(CDOffering offering, double balance){
			super(balance,offering.getInterestRate());
			this.offering = offering;
			this.startDate = new java.util.Date();
		}
		
		CDAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn, int term) {
			super(accountNumber, balance, interestRate, accountOpenedOn);
		}
		
		//@override
		public boolean withdraw(double amount) {
			return false;
		}
		
		//@override
		public boolean deposit(double amount) {
			return false;
		}
		
		public double getBalance() {
			return super.getBalance();
		}

		public double getInterestRate() {
			return super.getInterestRate();
		}
		public int getTerm() {
			return offering.getTerm();
		}
		public java.util.Date getstartDate(){
			return this.startDate;
		}
		public long getAccountNumber() {
			return super.getAccountNumber();
		}
		// This calculates the future value given the number of years
		public double futureValue() {
			return super.futureValue(this.getTerm());
			
		}
		
		static CDAccount readFromString(String accountData)throws ParseException 
		{
			CDAccount cdAccount;
			try 
			{
				ArrayList<String> accountValues = new ArrayList<String>(Arrays.asList(accountData.split(",")));
				long accountNumber = Long.parseLong(accountValues.get(0));
				double balance = Double.parseDouble(accountValues.get(1));
				double interestRate = Double.parseDouble(accountValues.get(2));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = accountValues.get(3);
				java.util.Date accountOpenedOn = new java.util.Date(dateString);
				accountOpenedOn = simpleDateFormat.parse(dateString);
				int term = Integer.parseInt(accountValues.get(4));
				cdAccount = new CDAccount(accountNumber, balance, interestRate, accountOpenedOn, term);
				return cdAccount;
			}
			catch(NumberFormatException nfe) 
			{
				nfe.printStackTrace();
				throw new java.lang.NumberFormatException();
			}
		}
		//@Override
		String writeToString() {
			return this.accountNumber + " " + this.balance + " " + this.interestRate  + 
					" " + this.accountOpenedOn + " " + this.term;
		}	
}