package com.meritamerica.assignment3;

import com.meritamerica.assignment2.AccountHolder;
import com.meritamerica.assignment2.CDOffering;
import com.meritamerica.assignment2.MeritBank;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
System.out.println("Hello Merit America!");
		
		CDOffering[] offerings = {new CDOffering(1,1.8/100),
								  new CDOffering(2,1.9/100),
								  new CDOffering(3,2.0/100),
								  new CDOffering(5,2.5/100),
								  new CDOffering(10,2.2/100)
								 
		};
		MeritBank.setCDOfferings(offerings);
		
		AccountHolder ah1 = new AccountHolder();
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		ah1.addCheckingAccount(50000);
		ah1.addSavingsAccount(500000);
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		ah1.addCDAccount(MeritBank.getBestCDOffering(100), 100);
		MeritBank.addAccountHolder(ah1);
		
		AccountHolder ah2 = new AccountHolder();
		ah2.addCheckingAccount(1000);
		ah2.addSavingsAccount(10000);
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(100),100);
		MeritBank.addAccountHolder(ah2);
		MeritBank.clearCDOfferings();
		
		AccountHolder ah3 = new AccountHolder();
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(100),100);
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		MeritBank.addAccountHolder(ah3);
		double totalBalance = MeritBank.totalBalances();
	}
	
	
}
	}
}