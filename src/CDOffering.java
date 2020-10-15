package com.meritamerica.assignment3;

public class CDOffering {
	public class CDOffering {
		private int term;
		private double interestRate;
		
		CDOffering(int term, double interestRate){
			this.term = term;
			this.interestRate = interestRate;
		}
		int getTerm() {
			return this.term;
		}
		double getInterestRate() {
			return this.interestRate;
		}
	}

}
