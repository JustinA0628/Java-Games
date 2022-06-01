package com.cs.main;

import java.util.ArrayList;

public class FrugalCustomer extends Customer {
   public Car purchase(ArrayList<Car> listOfCars) {
	  int min = listOfCars.get(0).getBasePrice();
	  int index=0;
      if(listOfCars.size() > 0) {
    	 for (int i = 0;i<listOfCars.size();i++) {
    		 if (min > listOfCars.get(i).getBasePrice()) {
    			 min = listOfCars.get(i).getBasePrice();
    			 index = i;
    		 }
    	 }
         return listOfCars.get(index);
      }
      else {
         return null;
      }
   }
}
