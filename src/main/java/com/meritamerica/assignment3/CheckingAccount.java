package com.meritamerica.assignment3;

import com.meritamerica.assignment3.BankAccount;

	public class CheckingAccount extends BankAccount {

		public CheckingAccount(double balance) {
			super(balance,0.0001);
		}
		static CheckingAccount readFromString(String accountData) throws ParseException{
			
		}
	}
