package com.cs.main;

import java.util.ArrayList;

public class View
{
   public View() {}

   public void printInventory(ArrayList<Car> inv)
   {
      System.out.println("========================================");
      System.out.println("CURRENT INVENTORY");
      for(Car c : inv)
         System.out.println(c + "\n");
      System.out.println("========================================");
   }
   
   public void printPurchase(Customer cust, Car car)
   {
      System.out.println(cust.getClass().getName().toUpperCase() + " purchased: ");
      System.out.println(car);
   }
}