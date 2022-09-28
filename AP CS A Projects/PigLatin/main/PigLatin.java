package com.help.main;


/**
 * Write a description of class PigLatin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class PigLatin
{
    /*
     * Precondition:  s is a String containing a single word.
     * Postcondition: returns a word converted into Pig Latin according to the appropriate rule.
     * 
     */
	
	public static String ruleOne(String str) {
		String firstLetter = str.substring(0,1);
		if(isVowel(firstLetter)) {
			str = str+"way";
		}
		return str;
	}
	public static String ruleTwo(String str) {
		String firstLetter = str.substring(0,1);
		String secondLetter = str.substring(1,2);
		if(!isVowel(firstLetter) && isVowel(secondLetter)) {
			str = str.substring(1) + firstLetter + "ay";
		}
		return str;
	}
	public static String ruleThree(String str) {
		String firstTwo = str.substring(0,2);
		if(!isVowel(str.substring(0,1))  && !isVowel(str.substring(1,2))){
			str = str.substring(2) + firstTwo+"ay";
		}
		return str;
	}
	
	public static boolean isVowel(String s) {
		// converts the single string value to lowercase in order to compare vowels
		s = s.toLowerCase();
		if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")) {
			return true;
		}
		return false;
	}
	
	public static String startsVowel(String s) {
		return ruleOne(s);
	}
	public static String startsConsonant(String s) {
		return ruleTwo(s);
	}

    public static String startsTwoConsonant(String s) {
    	return ruleThree(s);
    }
    
    public static String convertWord(String s) {
    	// this means that rule one is changed therefore making this rule apply
    	
    	if(s.indexOf(" ")!=-1) {
    		return convertSentence(s);
    	}else if(s!=ruleOne(s)) { 
    		return ruleOne(s);
    	} else if(s!=ruleTwo(s)) {
    		return ruleTwo(s);
    	} 
    	return ruleThree(s);
    }  
    
    public static String convertSentence(String s) {
    	String s1,s2,s3;
    	int i1,i2;
    	
    	// grabs from 0 to first space
    	i1 = s.indexOf(" ");
    	s1 = s.substring(0,i1);
    	
    	// grabs from first space to second space
    	String temp = s.substring(i1+1);
    	i2 = temp.indexOf(" ");
    	s2 = temp.substring(0,i2);
    	
    	// substring from the last space to the end
    	s3 = temp.substring(i2+1);
    	
    	return (convertWord(s1) +" "+ convertWord(s2) +" "+convertWord(s3));

    }   

}
