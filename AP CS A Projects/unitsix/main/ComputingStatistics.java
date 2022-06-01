package com.unitsix.main;

import java.util.ArrayList;

public class ComputingStatistics {
   /**
   * The ArrayList containing all of the loan data.
   */
   private ArrayList<Loan> data;
   
   /**
    * Creates a new ComputingStatistics object with an empty ArrayList 
    */
   public ComputingStatistics() {
      data = new ArrayList<Loan>();
   }
   
   /**
    * Creates a new ComputingStatistics object with the data passed in
    */
   public ComputingStatistics(ArrayList<Loan> d) {
      data = d;
   }
   
   /**
    * Calclates the total amount funded from all of the loans in the file.
    * @return the total loan amount.
    */
   public double totalAmount() {
      double amount = 0.0;
      for(int i = 0; i < data.size(); i++) {
         amount = amount + data.get(i).getLoanAmount();
      }
      return amount;
   }
   public double avgLoan(){
     return (totalAmount()/data.size());
   }
   public double largestLoan(){
     double max = data.get(0).getLoanAmount();
     for(int i = 0;i<data.size();i++){
       if(max<data.get(i).getLoanAmount()){
         max = data.get(i).getLoanAmount();
       }
     }
     return max;
   }
   public double smallestLoan(){
     double min = data.get(0).getLoanAmount();
     for (int i = 0;i<data.size();i++){
       if(min>data.get(i).getLoanAmount()){
         min = data.get(i).getLoanAmount();
        }
     }
     return min;
   }
   
   
   public String smallestLoanCountry(){
     double min = data.get(0).getLoanAmount();
     int j = 0;
     for (int i = 0;i<data.size();i++){
       if(min>data.get(i).getLoanAmount()){
         min = data.get(i).getLoanAmount();
         j=i;
        }
     }
     return data.get(j).getCountry();
   }
  
   public String largestLoanCountry(){
     double max = data.get(0).getLoanAmount();
     int j = 0;
     for (int i = 0;i<data.size();i++){
       if(max<data.get(i).getLoanAmount()){
         max = data.get(i).getLoanAmount();
         j=i;
        }
     }
     return data.get(j).getCountry();
   }
   
   public double avgDaysToFund() {
	   double count = 0;
	   for(int i = 0;i<data.size();i++) {
		   count+=data.get(i).getDaysToFund();
	   }
	   return count/=data.size();
	   
   }
   
   public double largestLoanKenya() {
	   ArrayList<Double> kenyaList = new ArrayList<Double>();
	   for(int i = 0;i<data.size();i++) {
		   if(data.get(i).getCountry().equals("Kenya")) {
			   kenyaList.add(data.get(i).getLoanAmount());
			   
		   }
	   }
	   double max = kenyaList.get(0);
	   for(int i = 0;i<kenyaList.size();i++) {
		   if(max<kenyaList.get(i)) {
			   max = kenyaList.get(i);
		   }
	   }
	   return max;
   }
   public double avgLoanPhilippines() {
	   double count = 0;
	   int numOfPhilippines=0;
	   for (int i = 0;i<data.size();i++) {
		   if(data.get(i).getCountry().equals("Philippines")) {
			   count+=data.get(i).getLoanAmount();
			   numOfPhilippines++;
		   }
	   }
	   

	   count/=numOfPhilippines;
	   return count;
   }
   public String longestToFundCountry() {
	  int max = data.get(0).getDaysToFund();
	  int j = 0;
	  for(int i =0;i<data.size();i++) {
		  if(max<data.get(i).getDaysToFund()) {
			  max = data.get(i).getDaysToFund();
			  j=i;
		  }
	  }
	  return data.get(j).getCountry();
	 
   }
   public String mostLoansFunded() {
	   double kenyaSum=0;
	   double elSalvadorSum=0;
	   for(int i = 0;i<data.size();i++) {
		   if(data.get(i).getCountry().equals("Kenya")) {
			   kenyaSum+=data.get(i).getLoanAmount();
		   } else if (data.get(i).getCountry().equals("El Salvador")) {
			   elSalvadorSum+=data.get(i).getLoanAmount();
		   }
	   }
	   if(kenyaSum>elSalvadorSum) {
		   return "Kenya";
	   } else {
		   return "El Salvador";
	   }
   }

}

