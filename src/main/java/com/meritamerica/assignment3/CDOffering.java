package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
		static CDOffering readFromString(String cdOfferingDataString)
		{
			CDOffering cdOffering;
			try 
			{
				ArrayList<String> accountValues = new ArrayList<String>(Arrays.asList(cdOfferingDataString.split(",")));
				int stringTerm = Integer.parseInt(accountValues.get(0));
				double stringRate = Double.parseDouble(accountValues.get(1));
				cdOffering = new CDOffering(stringTerm, stringRate);
				return cdOffering;
			}
			catch(NumberFormatException nfe) 
			{
				nfe.printStackTrace();
				throw new java.lang.NumberFormatException();
			}
		}
}