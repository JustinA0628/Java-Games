package com.cs.main;

import java.util.ArrayList;
import java.util.Random;

public class ImpulseCustomer extends Customer
{
  
   public Car purchase(ArrayList<Car> listOfCars)
   {
	  
	  int max = listOfCars.size()-1;
	  int min = 0;
	  int randomIndex = random(max,min);
	  
	  
      if(listOfCars.size() > 0 && Math.random()>=.5)
         return listOfCars.get(randomIndex);
      else
         return null;
   }
   
 
   public void upgrade(Car c)
   {
	  int max = c.getFeatures().size()-1;
	  int min = 0;
	  int randomIndex = random(max,min);
	  System.out.println(randomIndex);
      if(c.getFeatures().size() > 0)
      {         
         c.getFeatures().get(randomIndex).purchase();
      }
   }
   
   public int random(int max, int min) {
	   Random random = new Random();
	   int r = random.nextInt(max - min + 1) + min;
	   if(r<0) {
		   r=0;
	   }
	   return r;
   
   }
}
