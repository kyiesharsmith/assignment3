package com.meritamerica.assignment3;
	import java.util.Arrays;
	import java.util.Random;

	public class MeritBank {
		
		private static AccountHolder[] customers = {};
		private static CDOffering[] cds = null;
		private static long accountnumber = 0;
		
		static void addAccountHolder(AccountHolder accountHolder) {
	 
			AccountHolder[] bigger = new AccountHolder[MeritBank.customers.length+1];
			
			for(int i = 0; i<MeritBank.customers.length;i++) {
				bigger[i] = MeritBank.customers[i];
			
			}
			bigger[MeritBank.customers.length] = accountHolder;
			MeritBank.customers = bigger;
		}
		static AccountHolder[] getAccountHolders() {
			return MeritBank.customers;
		}
		static CDOffering[] getCDOfferings() {
			return MeritBank.cds;
		}
		static CDOffering getBestCDOffering(double depositAmount) {
			CDOffering best = null;
			double maxValue = 0;
			
			for(int i = 0; i<MeritBank.cds.length;i++) {
				CDOffering currentCD = MeritBank.cds[i];
				double cdValue = MeritBank.futureValue(depositAmount, currentCD.getInterestRate(), currentCD.getTerm());
				if (cdValue>=maxValue) { 
					best = currentCD;
					maxValue = cdValue;
				}
			
			}
			return best;
		}
		static CDOffering getSecondBestCDOffering(double depositAmount) {
			CDOffering secondBest = null ;
			CDOffering best = getBestCDOffering(depositAmount);
			double secondMaxValue = 0;
			
			for(int i = 0; i<MeritBank.cds.length;i++) {
				CDOffering currentCD = MeritBank.cds[i];
				double cdValue = MeritBank.futureValue(depositAmount, currentCD.getInterestRate(), currentCD.getTerm());
				if (cdValue>=secondMaxValue && (!currentCD.equals(best))){ 
					secondBest = currentCD;
					secondMaxValue = cdValue;
				}
			
			}
			return secondBest;
		}
		static void clearCDOfferings() {
			MeritBank.cds = null;
			
			
		}
		static void setCDOfferings(CDOffering[] offerings) {
			MeritBank.cds = offerings;
		}
		static long getNextAccountNumber() {
			return MeritBank.accountnumber++;
		}
		static double totalBalances() {
			double totalBalances = 0;
			for(int i = 0; i<MeritBank.customers.length;i++) {
				totalBalances += MeritBank.customers[i].getCombinedBalance();
				//totalBalances += MeritBank.customers[i].getCDBalance();
			}
			return totalBalances;
		}
		static double futureValue(double presentValue, double interestRate, int term) {
			return presentValue * (Math.pow(1 + interestRate, term));
		}
	}
