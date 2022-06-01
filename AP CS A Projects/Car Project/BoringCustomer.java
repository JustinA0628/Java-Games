package com.cs.main;

import java.util.ArrayList;

public class BoringCustomer extends Customer
{
   // a BoringCustomer just purchases the first car in the inventory
   public Car purchase(ArrayList<Car> listOfCars)
   {
      if(listOfCars.size() > 0)
         return listOfCars.get(0);
      else
         return null;
   }
   
   // a BoringCustomer purchases only the first feature upgrade available (if there is one)
   public void upgrade(Car c)
   {
      if(c.getFeatures().size() > 0)
      {         
         c.getFeatures().get(0).purchase();
      }
   }
}