package com.cs.main;

import java.util.ArrayList;

public class BargainCustomer extends Customer
{
   private int balance;
   ArrayList<Car> newLoc = new ArrayList<Car>();
   public Car purchase(ArrayList<Car> listOfCars, int budget)
   {
	  balance = budget;
	  
	  int averageCost = 0;
	  
      if(listOfCars.size() > 0) {
    	  // sorts through the array list and adds the cars that are avaliable to buy 
    	  for (int i = 0;i<listOfCars.size();i++) {
    		  if (listOfCars.get(i).getBasePrice()<=budget) {
    			  averageCost += listOfCars.get(i).getBasePrice();
    			  newLoc.add(listOfCars.get(i));
    		  }
    	  }
    	 averageCost /= newLoc.size()-1;
    	 
    	 // this checks for the first car that has a price range between the average cost of newLoc arraylist
    	 for(int i = newLoc.size()-1;i>=1;i--) {
    		 if(newLoc.get(i).compareTo(newLoc.get(i-1))>=averageCost+10000 
    				 ||newLoc.get(i).compareTo(newLoc.get(i-1))<=averageCost-10000 ) {
    			 balance-=newLoc.get(i).getBasePrice();
    			 return newLoc.get(i);
    		 }
    	 } 
    	 
    	 
         return null;
      }
      else {
         return null;
      }
   }
   
   public void upgrade(Car c){
      if(c.getFeatures().size() > 0) {         
    	 for(int i = 0;i<c.getFeatures().size();i++) {
    		 if(balance<=newLoc.get(i).getTotalCost()-newLoc.get(i).getBasePrice()) {
    			 c.getFeatures().get(i).purchase();
    		 }
    	 }
      }
   }
	   
}
