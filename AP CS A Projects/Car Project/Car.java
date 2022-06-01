package com.cs.main;

import java.util.ArrayList;

public class Car
{
   //instance variables
   private String model;
   private int basePrice;
   private ArrayList<Feature> features;
   
   //constructor
   public Car(String m, int b, ArrayList<Feature> f)
   {
      model = m;
      basePrice = b;
      features = f;
   }
   
   //accessors
   public String getModel() {
	   return model; 
   }
   public int getBasePrice() { 
	   return basePrice;
   }
   public ArrayList<Feature> getFeatures() {
	   return features; 
   }
   
   //mutators
   //none
   
   //toString
   public String toString()
   {
      String toReturn = "";
      toReturn += model.toUpperCase();
      for(Feature f : features)
      {
         toReturn += "\n--" + f.toString();
         if(f.isPurchased())
            toReturn += " (purchased)";
         else
            toReturn += " (not purchased)";
      }
      toReturn += "\nTOTAL COST $" + getTotalCost();
      return toReturn;
   }
   
   //other methods
   public int getTotalCost()
   {
	  int cost  = 0;
	  cost += basePrice;
	  for (int i = 0;i<features.size();i++) {
		  cost += features.get(i).getCost();
	  }
	  
      return cost;
   }

   //Please provide equals() to compare two cars based on the model only to override the 
   //default equals() method from Object. 
   public boolean equals(Car other)
   {
	  return model.equals(other.getModel());
	  
   }


   //compareTo() method to compare the final cost of the two cars only, again it will override 
   //the default compareTo() method from Object class.
   public int compareTo(Car other)
   {
	  int cost1 = getTotalCost();
	  int cost2 = other.getTotalCost();
	  
	  
      return cost1-cost2;
   }
   

}