package com.meritamerica.assignment3;
import java.util.Arrays;

import com.meritamerica.assignment2.BankAccount;
import com.meritamerica.assignment2.CDAccount;
import com.meritamerica.assignment2.CDOffering;
import com.meritamerica.assignment2.CheckingAccount;
import com.meritamerica.assignment2.SavingsAccount;

public class AccountHolder {
	public class AccountHolder {
		public static final int YEARS = 3;
			
			//instance variables
			private String firstName;
			private String middleName;
			private String lastName;
			private String ssn;
			
			private BankAccount[] accounts;
			
			
			//default constructor
			public AccountHolder(){
				//initializing values
			    this.firstName = "none";
			    this.middleName = "none";
			    this.lastName = "none";
			    this.ssn = "none";
			    this.accounts = new BankAccount[0];
			  
			    
			}
			public AccountHolder(String firstName, 
					String middleName, 
					String lastName, 
					String ssn ){

		 
				//initializing values
				this.firstName = firstName;
			    this.middleName = middleName;
			    this.lastName = lastName;
			    this.ssn = ssn;
			    this.accounts = new BankAccount[0];
				
			}
			
			public AccountHolder(String firstName, 
					String middleName, 
					String lastName, 
					String ssn, 
					double checkingAccountOpeningBalance, 
					double savingsAccountOpeningBalance) {
				//initializing values
				this.firstName = firstName;
			    this.middleName = middleName;
			    this.lastName = lastName;
			    this.ssn = ssn;
			    this.accounts = new BankAccount[0];
			    this.addCheckingAccount(checkingAccountOpeningBalance);
			    this.addSavingsAccount(savingsAccountOpeningBalance);
			}
			
			public String getFirstName() {
				return this.firstName;
			}
			
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			
			public String getMiddleName() {
				return this.middleName;
			}
			
			public void setMiddleName(String middleName) {
				this.middleName = middleName;
			}
			
			public String getLastName() {
				return this.lastName;
			}
			
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			
			public String getSSN() {
				return this.ssn;
			}
			
			public void setSSN(String ssn) {
				this.ssn = ssn;
			}
			
			public CheckingAccount addCheckingAccount(double openingBalance) {
				CheckingAccount cAccount = new  CheckingAccount(openingBalance); 
				
				if((this.getCheckingBalance()+ this.getSavingsBalance()+cAccount.getBalance()) >= 250000) {
					return cAccount;
				}	
				BankAccount[] bigger = new BankAccount[this.accounts.length+1];
				
				for(int i = 0; i<this.accounts.length;i++) {
					bigger[i] = this.accounts[i];
				
				}
				bigger[this.accounts.length] = cAccount;
				this.accounts = bigger;
				return cAccount;
				
			}
			public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
				
				CheckingAccount cAccount = checkingAccount;
				
				if((this.getCheckingBalance()+ this.getSavingsBalance()+cAccount.getBalance()) >= 250000) {
					return cAccount;
				}	
				BankAccount[] bigger = new BankAccount[this.accounts.length+1];
				
				for(int i = 0; i<this.accounts.length;i++) {
					bigger[i] = this.accounts[i];
				
				}
				bigger[this.accounts.length] = cAccount;
				this.accounts = bigger;
				return cAccount;
				
			}
			public CheckingAccount[] getCheckingAccounts() {
				CheckingAccount[] cAccounts = new CheckingAccount[this.accounts.length];
				int numofChecking = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					if(this.accounts[i] instanceof CheckingAccount) {
						cAccounts[numofChecking] = (CheckingAccount) this.accounts[i];
						numofChecking++;
					}
				}	
				CheckingAccount[] rightSize = new CheckingAccount[numofChecking];
				for(int i = 0;i<rightSize.length;i++) {
					rightSize[i] = cAccounts[i];
				}
				return rightSize;
			}
			public int getNumberOfCheckingAccounts() {
				int numofChecking = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					if(this.accounts[i] instanceof CheckingAccount) {
						numofChecking++;
					}
				}
				return numofChecking;
			}
			public double getCheckingBalance() {
				CheckingAccount[] cAccounts = this.getCheckingAccounts();
				double cBalance = 0; 
				for(int i = 0; i<cAccounts.length; i++) {
					cBalance += cAccounts[i].getBalance();
				}
				return cBalance;
			}
			
			public SavingsAccount addSavingsAccount(double openingBalance) {
				SavingsAccount sAccount = new SavingsAccount(openingBalance); 
				
				if((this.getCheckingBalance()+ this.getSavingsBalance()+sAccount.getBalance()) >= 250000) {
					return sAccount;
				}	
				BankAccount[] bigger = new BankAccount[this.accounts.length+1];
				
				for(int i = 0; i<this.accounts.length;i++) {
					bigger[i] = this.accounts[i];
				
				}
				bigger[this.accounts.length] = sAccount;
				this.accounts = bigger;
				return sAccount;
				
			}
			
			public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
				
				SavingsAccount sAccount = savingsAccount; 
				
				if((this.getCheckingBalance()+ this.getSavingsBalance()+sAccount.getBalance()) >= 250000) {
					return sAccount;
				}	
				
				BankAccount[] bigger = new BankAccount[this.accounts.length+1];
				
				for(int i = 0; i<this.accounts.length;i++) {
					bigger[i] = this.accounts[i];
				
				}
				bigger[this.accounts.length] = sAccount;
				this.accounts = bigger;
				return sAccount;
				
			}
			
			public SavingsAccount[] getSavingsAccounts() {
				SavingsAccount[] sAccounts = new SavingsAccount[this.accounts.length];
				int numofSavings = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					if(this.accounts[i] instanceof SavingsAccount) {
						sAccounts[numofSavings] = (SavingsAccount) this.accounts[i];
						numofSavings++;
					}
				}	
				SavingsAccount[] rightSize = new SavingsAccount[numofSavings];
				for(int i = 0;i<rightSize.length;i++) {
					rightSize[i] = sAccounts[i];
				}
				return rightSize;
			}
			
			public int getNumberOfSavingsAccounts() {
				int numofSavings = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					if(this.accounts[i] instanceof SavingsAccount) {
						numofSavings++;
					}
				}	
				return numofSavings;
			}
			
			public double getSavingsBalance() {
				SavingsAccount[] sAccounts = this.getSavingsAccounts();
				double sBalance = 0; 
				for(int i = 0; i<sAccounts.length; i++) {
					sBalance += sAccounts[i].getBalance();
				}
				return sBalance;
			}
			
			public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
				if (offering == null) {
					return null;
				}
				CDAccount cdAccount = new CDAccount(offering, openingBalance);  
				BankAccount[] bigger = new BankAccount[this.accounts.length+1];
				
				for(int i = 0; i<this.accounts.length;i++) {
					bigger[i] = this.accounts[i];
				
				}
				bigger[this.accounts.length] = cdAccount;
				this.accounts = bigger;
				return cdAccount;
				
			}
			public CDAccount addCDAccount(CDAccount cdAccount) {
			
				  
				BankAccount[] bigger = new BankAccount[this.accounts.length+1];
				
				for(int i = 0; i<this.accounts.length;i++) {
					bigger[i] = this.accounts[i];
				
				}
				bigger[this.accounts.length] = cdAccount;
				this.accounts = bigger;
				return cdAccount;
				
			}
			
			
			public CDAccount[] getCDAccounts() {
				CDAccount[] cdAccounts = new CDAccount[this.accounts.length];
				int numofCDS = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					if(this.accounts[i] instanceof CDAccount) {
						cdAccounts[numofCDS] = (CDAccount) this.accounts[i];
						numofCDS++;
					}
				}	
				CDAccount[] rightSize = new CDAccount[numofCDS];
				for(int i = 0;i<rightSize.length;i++) {
					rightSize[i] = cdAccounts[i];
				}
				return rightSize;
			}
			
			public int getNumberOfCDAccounts() {
				int numofCDS = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					if(this.accounts[i] instanceof CDAccount) {
						numofCDS++;
					}
				}	
				return numofCDS;
			}
			
			public double getCDBalance() {
				CDAccount[] cdAccounts = this.getCDAccounts();
				double cdBalance = 0; 
				for(int i = 0; i<cdAccounts.length; i++) {
					cdBalance += cdAccounts[i].getBalance();
				}
				return cdBalance;
			}
			
			public double getCombinedBalance() {
				double balance = 0;
				for(int i = 0; i<this.accounts.length; i++) {
					
					//if(this.accounts[i] instanceof CheckingAccount ||
					  // this.accounts[i] instanceof SavingsAccount ) {
						balance += this.accounts[i].getBalance();
					//}
				}
				return balance;
			}
			
			
			
			public String toString() {
				return "Name: " + this.firstName + this.middleName + this.lastName +"\n"
						+ "SSN: " + this.ssn +"\n";
			}
	}
}
