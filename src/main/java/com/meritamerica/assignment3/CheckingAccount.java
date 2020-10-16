package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

	public class CheckingAccount extends BankAccount {		
		
		public CheckingAccount(double balance) {
			super(balance,0.0001);
		}
		
		public CheckingAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
			super(accountNumber, balance, interestRate, accountOpenedOn);
		}
		//accepts a string, then converts it into appropriate data types, returns CheckingAccount
		static CheckingAccount readFromString(String accountData)throws ParseException 
		{
			CheckingAccount checkingAccount;
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
				checkingAccount = new CheckingAccount(accountNumber, balance, interestRate, accountOpenedOn);
				return checkingAccount;
			}
			catch(NumberFormatException nfe) 
			{
				nfe.printStackTrace();
				throw new java.lang.NumberFormatException();
			}
		}
	}