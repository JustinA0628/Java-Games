package com.unitone.main;

public class Hotdog {
	
	public static void run() {
		// method asks user how many hotdogs they want to buy
		int numOfHotdogs;
		System.out.println("How many hotdogs do you want to buy?");
		numOfHotdogs = Main.scanner.nextInt();
		System.out.println("\nYour total cost is $"+cost(numOfHotdogs));
		
		
	}
	public static double cost(int num) {
		// mehtod calculates and return type double of the total cost
		double cost = 2.5*num;
		double savedCost;
		if (cost>20) {

			cost-=cost*.05;
			
			savedCost=(2.5*num)-cost;
			System.out.println("you saved $"+savedCost+" with 5% discount for orders over $20");
		}
		double tax =(cost*1.07);
		
		return tax;
	}
}
