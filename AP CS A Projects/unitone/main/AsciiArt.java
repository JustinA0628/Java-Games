package com.unitone.main;

public class AsciiArt {
	static boolean isStarLeft=true;
	
	public static void longStar() {
		// this method prints out the long star and it wont be printed on new line since it is a print statment
		for (int i = 0;i<=5;i++) {
			System.out.print("*");
		}
		
	
	}
	public static void singularStar() {
		// this if statement checks if its either left or right, and after it prints out the appropriate output it will reverse the bool
		if (isStarLeft) {
			System.out.println("\n*");
			isStarLeft=!isStarLeft;
		} else {
			System.out.println("\n     *");
			isStarLeft=!isStarLeft;
		}
	}
	

	public static void run() {
		// this is the proper steps in order to print out the art
		for (int i =0;i<=4;i++) {
			longStar();
			singularStar();
		}
		longStar();
	}	

	
}
