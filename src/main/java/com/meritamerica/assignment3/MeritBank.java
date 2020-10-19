package com.meritamerica.assignment3;
	import java.util.*;
	import java.io.*;

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
		static boolean readFromFile(String fileName){
			try
			{
				ArrayList<String> fileLines = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while(br.ready()) {
					fileLines.add(br.readLine());
				}
				accountnumber = Long.parseLong(fileLines.get(0));
				int offeringLength = Integer.parseInt(fileLines.get(1));
				cds = new CDOffering[offeringLength];
				for(int i = 2; i < 5; i++) {
					for(int x = 0; x < 2; x++) {
					cds[x] = CDOffering.readFromString(fileLines.get(i));
					}
				}
				AccountHolder[] total = new AccountHolder[2];
				//total[0] = fileLines.get(6);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return true;
		}
		
		static boolean writeToFile(String fileName) {
			
			try
			{
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return true;
		}

		static AccountHolder[] sortAccountHolders() {
		AccountHolder[] sortedAccountHolder = customers;
		Arrays.sort(sortedAccountHolder);
			return sortedAccountHolder;
		}
		
		static void setNextAccountNumber(long nextAccountNumber) {
			nextAccountNumber = nextAccountNumber+1;
		}
	}