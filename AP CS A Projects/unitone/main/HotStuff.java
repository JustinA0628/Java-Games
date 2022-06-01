package com.unitone.main;

public class HotStuff {

	static double celcius, fTemp;
	public static void run() {
		// asks user for fahrenheit
		System.out.println("What is the fahrenheit? ");
		fTemp = Main.scanner.nextDouble();
		celcius = convert(fTemp);
		
		System.out.println(checkWeather());
		
		System.out.println("The celcius temp is "+celcius);
		
	}
	public static double convert(double f) {
		// this is the calculation
		double conversion;
		// the reason why we have to place this in parentheses is because it won't be correctly converted
		conversion = (f-32)*5;
		conversion/=9;
		return conversion;
	}
	public static String checkWeather() {
		// this method shows an output of the temp 
		if (fTemp<=0) {
			return "Freeeezing!";
		} else if (fTemp>=100) {
			return "Hot!";
		} else {
			return "nice weather :)";
		}
		
		
	}
}
