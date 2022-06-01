package com.cs.main;


import java.util.ArrayList;

public class LuxuryCustomer extends Customer {
   
   public Car purchase(ArrayList<Car> listOfCars) {
	   int max = listOfCars.get(0).getBasePrice();
	   int index=0;
      if(listOfCars.size() > 0) {
    	 for (int i = 0;i<listOfCars.size();i++) {
    		 if (max < listOfCars.get(i).getBasePrice()) {
    			 max = listOfCars.get(i).getBasePrice();
    			 index = i;
    		 }
    	 }
         return listOfCars.get(index);
      }
      else {
         return null;
      }
   }

   public void upgrade(Car c){
      if(c.getFeatures().size() > 0) {         
    	 for(int i = 0;i<c.getFeatures().size();i++) {
    		 c.getFeatures().get(i).purchase();
    	 }
      }
   }
   
   
}
