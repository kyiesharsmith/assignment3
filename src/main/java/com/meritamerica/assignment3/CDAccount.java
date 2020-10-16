package com.meritamerica.assignment3;

	import com.meritamerica.assignment3.BankAccount;
	import com.meritamerica.assignment3.CDOffering;

	public class CDAccount extends BankAccount {
		private  CDOffering offering;
		private java.util.Date startDate;
		
		
		
		CDAccount(CDOffering offering, double balance){
			super(balance,offering.getInterestRate());
			this.offering = offering;
			this.startDate = new java.util.Date();
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
}
