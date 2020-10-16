package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

	public class SavingsAccount extends BankAccount {
		
		public SavingsAccount(double balance) {
			super(balance,0.01);
		}
		
		public SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, balance, interestRate, accountOpenedOn);
		}
		//accepts a string, then converts it into appropriate data types, returns SavingsAccount
		static SavingsAccount readFromString(String accountData)throws ParseException 
		{
			SavingsAccount savingsAccount;
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
				savingsAccount = new SavingsAccount(accountNumber, balance, interestRate, accountOpenedOn);
				return savingsAccount;
			}
			catch(NumberFormatException nfe) 
			{
				nfe.printStackTrace();
				throw new java.lang.NumberFormatException();
			}
		}
}