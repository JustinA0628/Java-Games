package com.cs.main;

public class Feature{
	  private String name;
	  private double cost;
	  private boolean purchased;
	  public Feature(String n, double c){
	    name = n;
	    cost = c;
	  }
	  public String getName(){
	    return name;
	  }
	  public double getCost(){
	    return cost;
	  }
	  public boolean isPurchased(){
	    return purchased;
	  }
	  public void purchase(){
	    purchased=true;
	  }
	  public String toString(){
	    return "Name: "+name+" Cost: "+cost+" is purchased: "+purchased;
	  }

	}
