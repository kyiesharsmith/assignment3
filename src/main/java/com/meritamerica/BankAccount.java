package com.meritamerica.assignment3;
import java.util.Date;

public class BankAccount {
		private double balance;
		private double interestRate;
		private java.util.Date accountOpenedOn;
		private long accountNumber;
		
		BankAccount(double balance, double interestRate){
			this.balance = balance;
			this.interestRate = interestRate;
			
			this.accountNumber = -1;
		}
		BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn){
			this.balance = balance;
			this.interestRate = interestRate;
			this.accountOpenedOn = accountOpenedOn;
		}
		BankAccount(long accountNumber, double balance, double interestRate){
			this.balance = balance;
			this.interestRate = interestRate;
			
			this.accountNumber = accountNumber;
		}
		BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn){
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.interestRate = interestRate;
			this.accountOpenedOn = accountOpenedOn;
			
		}
		public long getAccountNumber() {
			return this.accountNumber;
		}
		public double getBalance() {
			return this.balance;
		}

		public double getInterestRate() {
			return this.interestRate;
		}
		public java.util.Date getOpenedOn(){
			return this.accountOpenedOn;

		public boolean withdraw(double amount) {
			if (this.balance >= amount && amount >= 0) {
				this.balance = this.balance - amount;
				return true;
			} else {
				return false;
			}

		}

		public boolean deposit(double amount) {
			if (amount >= 0) {
				this.balance = this.balance + amount;
				return true;
			}
			else {
				return false;
			}
		}
		
		// This calculates the future value given the number of years
		public double futureValue(int years) {
			return this.balance * (Math.pow(1 + this.interestRate, years));
		}
		static BankAccount readFromString(String accountData)throws ParseException {
			
		}
		
		public String toString() {
			return this.accountNumber + " " + this.balance;
		}
	}


}
