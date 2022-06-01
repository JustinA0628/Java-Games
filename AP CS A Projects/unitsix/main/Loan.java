package com.unitsix.main;

public class Loan{
	  private int id;
	  private double loanAmount;
	  private String country;
	  private int daysToFund;
	  private int numLenders;
	  public Loan(int i, double l, String c, int d, int n) {
	    id = i;
	    loanAmount = l;
	    country = c;
	    daysToFund = d;
	    numLenders = n;
	  }
	  public int getID(){
	    return id;
	  }
	  public double getLoanAmount(){
	    return loanAmount;
	  }
	  public String getCountry(){
	    return country;
	  }
	  public int getDaysToFund(){
	    return daysToFund;
	  }
	  public int getNumLenders(){
	    return numLenders;
	  }
	  public String toString(){
	    return "Loan Amount: "+loanAmount+", Country: "+country;
	  }

	  public void setID(int i){
	    id = i;
	  }
	  public void setLoanAmount(double sla){
	    loanAmount=sla;
	  }
	  public void setCountry(String c){
	    country = c;
	  }
	  public void setDaysToFund(int dtf){
	    daysToFund=dtf;
	  }
	  public void setNumLenders(int n){
	    numLenders=n;
	  }

	}