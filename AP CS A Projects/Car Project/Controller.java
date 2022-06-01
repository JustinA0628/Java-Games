package com.cs.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Controller
{
   public static void main(String[] args)
   {
      View storeView = new View();
      ArrayList<Car> storeInventory = loadInventory();
      
      storeView.printInventory(storeInventory);
      
      BoringCustomer bill = new BoringCustomer();
      Car c = bill.purchase(storeInventory);
      bill.upgrade(c);
      storeView.printPurchase(bill,c);
      
      ImpulseCustomer tim = new ImpulseCustomer();
      Car c2 = tim.purchase(storeInventory);
      tim.upgrade(c2);
      storeView.printPurchase(tim,c2);
      
      
      LuxuryCustomer rich = new LuxuryCustomer();
      Car c3 = rich.purchase(storeInventory);
      rich.upgrade(c3);
      storeView.printPurchase(rich,c3);
      
      FrugalCustomer broker = new FrugalCustomer();
      Car c4 = broker.purchase(storeInventory);
      storeView.printPurchase(broker,c4);
      
      
      BargainCustomer fin = new BargainCustomer();
      Car c5 = fin.purchase(storeInventory,40000);
      fin.upgrade(c5);
      storeView.printPurchase(fin,c5);
      
   }
   
   public static ArrayList<Car> loadInventory()
   {
      ArrayList<Car> inventory = new ArrayList<Car>();
      Scanner file = null;
		try {
 			file = new Scanner(new File("C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\src\\com\\cs\\main\\inventory.txt"));
	
			while(file.hasNextLine())
			{
				String carModel = file.nextLine();
            int carBasePrice = file.nextInt(); file.nextLine();
            
            ArrayList<Feature> carFeatures = new ArrayList<Feature>();
            String next = "enterloop";
            int featureCost;
            while(file.hasNextLine() && !next.equals(""))
            {
               next = file.nextLine();
               if(!next.equals(""))
               {
                  featureCost = file.nextInt(); file.nextLine();
                  carFeatures.add(new Feature(next,featureCost));
               }
            }
            if(next.equals("") || !file.hasNextLine())
               inventory.add(new Car(carModel, carBasePrice, carFeatures));
			}
	
		}
		catch (Exception e)
		{
         System.out.println("Something went wrong with the text file: ");
         e.printStackTrace();
		}
      return inventory;
   }
   
   
}