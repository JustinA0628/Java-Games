package com.unitone.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int selectedProgram;
	static List<String> programName = new ArrayList<String>();
	public static void main(String[] args) {
		// this adds all of the values to List
		programName.add("Average Grade");
		programName.add("Hotdog");
		programName.add("Hot Stuff");
		programName.add("Ascii Art");
		
		listPrograms();
		welcome();
		

	}
	public static void listPrograms() {
		// this method lists all the programs
		for (int i =0;i<=programName.size()-1;i++) {
			System.out.println(i+". "+programName.get(i));
		}
	}
	
	public static void welcome() {
		// this method displays the options you can select 
		System.out.println("\nWelcome! TYPE a number 0-3 to select a project");
		selectedProgram = scanner.nextInt();
		switch (selectedProgram) {
			case 0: AverageGrade.run();
				break;
			case 1: Hotdog.run();
				break;
			case 2: HotStuff.run();
				break;
			case 3:AsciiArt.run();
				break;
		}
	}
}
