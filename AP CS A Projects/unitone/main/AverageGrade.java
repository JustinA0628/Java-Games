package com.unitone.main;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class AverageGrade {
	// this creates the List
	static List <Double> grades = new ArrayList<Double>();
	public static void run() {
		double usersNum;
		System.out.println("Hello, enter in 3 grades");
		
		for (int i = 1;i<=3;i++) {
			
			System.out.println(i+". ");
			usersNum = Main.scanner.nextDouble();
			grades.add(usersNum);
		}
		System.out.print("Your average grade is ");
		System.out.println(calculate(grades.get(0),grades.get(1),grades.get(2))+"%");
		System.out.println();
		sort();
	}
	public static double calculate(double a,double b, double c) {
		// this calculates and returns the var of type double grade
		double average = 0;
		for (int i = 0;i<=2;i++) {
			average+=grades.get(i);
		}
		return average/3;
		
	}
	
	public static void sort() {
		// line 36 calls in the Collections class' method "sort" and is used to sort an array list in ascending order
		Collections.sort(grades); 
		
		for (int i = 0;i<=2;i++) {
			System.out.print(determineGrade(i)+":"+grades.get(i)+"% ");
	
		}
	}
	
	public static char determineGrade(int percentGrade) {
		// this method returns the grade as in type char
		if (grades.get(percentGrade)>=90) {
			return 'A';
		} else if(grades.get(percentGrade)>=80) {
			return 'B';
		} else if (grades.get(percentGrade)>=70){
			return 'C';
		} else if (grades.get(percentGrade)>=60) {
			return 'D';
		} else {
			return 'F';
		}
		
		
	}
	
}
