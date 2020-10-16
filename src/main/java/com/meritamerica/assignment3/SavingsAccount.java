package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.meritamerica.assignment3.BankAccount;

	public class SavingsAccount extends BankAccount {
		static private double balance;
		static private double interestRate;
		static private java.util.Date accountOpenedOn;
		static private long accountNumber;
		
		public SavingsAccount(double balance) {
			super(balance,0.01);
		}
		public SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, balance, interestRate, accountOpenedOn);
		}
		static SavingsAccount readFromString(String accountData)throws ParseException {
			try {
				if(true) {
				String [] accountValues = accountData.split(",");
				long accountNumber = Long.parseLong(accountValues[0]);
				double balance = Double.parseDouble(accountValues[1]);
				double interestRate = Double.parseDouble(accountValues[2]);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = accountValues[3];
				java.util.Date accountOpenedOn = new java.util.Date(dateString);
				}
					else {
						throw new ParseException("accountData not able to be parsed", 71);
					}
			}
			catch(ParseException e) {
				e.printStackTrace();
			}
			return new SavingsAccount(accountNumber, balance, interestRate, accountOpenedOn);
		}
}
