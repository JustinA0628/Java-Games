package com.unittwo.main;


import java.util.*;



public class TextAdventure {
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;
  
  private String selectedWeapon = "fist";
  public TextAdventure() {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0);
  }

  public void play() throws InterruptedException {
	  
	
    String input;
    // start of adventure. You can change this if you like
    
    //console.setImage("image.jpg"); 

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    // ADD CODE HERE
    ourHero.changeName(input); 
       
    
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself on the edge of a shadowy forest with the sun nearly set. \nYou see what looks like a city in the distance. ");
    requestsLocation();
 
  }

  private void enterZone1() throws InterruptedException {
    // change image
    // ADD CODE HERE
    
    //console.setImage("1city.jpg.png"); 
    // describe the area/situation to the user. 
    System.out.println("You had arrived to the city! it is a very cold place,");
    
    
    
    if (Math.random()>.50) {
    	System.out.println("\nYou had stumbled across an unopened treasure chest!\n you had gained some gold!");
    	ourHero.setGold(ourHero.getGold()+10);
    	// console.setImage("") Treasure chest, 
    	Thread.sleep(1000);
    	
    	// console.setImage("1city.jpg.png");
    	System.out.println("Now you're more rich, where do you want to go?");
    } else {
    	System.out.println("\nYour luck had expired and you're now against a mini dragon fight and duels you in a game of chance!");
    	Thread.sleep(500);
    	if(!(Math.random()>.2)) {
    		System.out.println("You are seriously injured! But thankfully you had ran away!");
    		
    		
    		
    		ourHero.setHealth(ourHero.getHealth()-50);
    		checkUsersHealth();

    	} else {
    		System.out.println("You had won against him!");
    		ourHero.setGold(ourHero.getGold()+10);
    		
    		System.out.println("Assuming you're not dead, where do you want to go?");	
    	}
    	ourHero.defeatMonster();   	
    }

    
    requestsLocation();

  }

  private void enterZone2() throws InterruptedException {
    // change image to forest
    
	  
    // describe the area/situation to the user.
	  System.out.println("it is a very spooky cold place and you are ended up in a forest,\n you are starving and found some berries, would you eat it?");
	  
    // Give them options for choices.
	  String input;
	  input = inScanner.nextLine();
	  if (input.equalsIgnoreCase("yes")) {
		  if (Math.random()<.5) {
			  System.out.println("You're very lucky you didn't die! You had gained some health");
			  ourHero.setHealth(ourHero.getHealth()+10);
		  } else {
			  System.out.println("You're not so lucky that you ate those berries, you now have a severe sickness!");
			  ourHero.setGold(ourHero.getHealth()-20);
		  }
	  }
	  Thread.sleep(1000);
	  System.out.println("\nWhile stumbling across this big forest, you had found a big green monster! Do you pick \n1. A spear \n2. a bow and arrow\n");
	  input = inScanner.nextLine();
	  
	  
	  if (input.equalsIgnoreCase("Bow and arrow")||input.equalsIgnoreCase("2")) {
		  System.out.println("You had deflected minor damage, unfortunately that wasn't the best option.\n You had lost some damage but had won");
		  ourHero.defeatMonster();
	  } else if (input.equals("Spear") || input.equalsIgnoreCase("1")) {
		  System.out.println("Your arms aren't the strongest and you thought a spear would work, the monster deals a lot of damage!");
		  
		  
		  ourHero.setHealth(ourHero.getHealth()-40);
		  checkUsersHealth();
	  } else {
		  System.out.println("You just stood there and now you get severly damaged, you need to go to a hospital ASAP!");
		  
		  
		  ourHero.setHealth(ourHero.getHealth()-90);
		  checkUsersHealth();
	  }
	  ourHero.defeatMonster();
    // Take action or go to another zone based on their choice

	  System.out.println("That was a tough fight, ");
	 requestsLocation();
    
  }
  
  private void enterZone3() throws InterruptedException {
	    // change image to desert

		  
	    // describe the area/situation to the user.
		  System.out.println("\nYou sat on the ground thinking about water all day in the dry heat of the desert, \n You had found some sketchy water bottle on the ground");
		  String input;
		  
		  System.out.println("Do you drink it? \n1.Yes\n2.No way!\n");
		  input = inScanner.nextLine();
		  if (input.equalsIgnoreCase("Yes")||input.equalsIgnoreCase("1")) {
			  System.out.println("The water tastes really bad but well get you through the day!");
			  ourHero.setHealth(ourHero.getHealth()+5);
		  } else {
			  System.out.println("You are in need of water, but you can get through the day, hopefully");
			  
			  
			  ourHero.setHealth(ourHero.getHealth()-5);
			  checkUsersHealth();
		  }

		  Thread.sleep(1000);
		  System.out.println("You start to have hallucinations and you need it to stop!\nYou find your self in a dilemma where there are two fruits infornt of you."
		  		+ "\nDo you...\n1.Eat the watermelon\n2.Eat the mango\n");
		  input = inScanner.nextLine();
		  if (input.equalsIgnoreCase("watermelon")) {
			  System.out.println("Ouch! You just bit into a poisonous Scorpion! \n your health had dropped to 1! go to the hospital!");
			  ourHero.setHealth(1);
		  } else  {
			  System.out.println("You just bit into an open cactus with amazing health benefits!");
			  ourHero.setHealth(ourHero.getHealth()+10);
		  } 
		  
		  System.out.println("You had enough of the desert and now you want to leave! ");
		  requestsLocation();
	  }

  private void enterZone4() throws InterruptedException {
    // change image to hospital

	  
    // describe the area/situation to the user. 
	  System.out.println("\nYou had arrived to the hospital! it is a very welcoming place!");
    // Give them options for choices.
	  String input;
	  String listBalance = "\n\nYou have "+ourHero.getGold()+" gold";
    if (ourHero.getGold()>20) {
    	
    	System.out.println("Would you like to \n1.Show how much gold you have \n2.Add health");
    	input = inScanner.nextLine();
    	if (input.equalsIgnoreCase("1")) {
    		System.out.println(listBalance);
    	} else {
    		System.out.println("You had spent 10 gold to keep your health up!");
    		ourHero.setHealth(100);
    		ourHero.setGold(ourHero.getGold()-10);
    		System.out.println(listBalance);
    	}
    	
    } else {
    	Thread.sleep(1000);
    	System.out.println("\nI guess it wasn't so welcoming after all they had kicked you for being broke!");
    	
    }

    requestsLocation(); 
  }



  private void enterZone5() throws InterruptedException {
    // change image to mountains
	  
    // describe the area/situation to the user. 
	  System.out.println("It is very cold and windy up here!");
    // Give them options for choices.
    // ADD CODE HERE
	  System.out.println("You are met with a shopkeeper and he wants to sell his 3 tools for your fight of the Great Dragon, ");
	  System.out.println("A sword, bow and arrow, or knife\n");
	  System.out.println("These items cost 15 gold");
	  String input;
    // Take action or go to another zone based on their choice
	  input = inScanner.nextLine();
	  if (input.equalsIgnoreCase("sword")) { 
		  selectedWeapon = "sword";
		  ourHero.setGold(ourHero.getGold()-15);
		  
	  } else if (input.equalsIgnoreCase("bow and arrow")) {
		  selectedWeapon = "bow and arrow";
		  ourHero.setGold(ourHero.getGold()-15);
	  } else {
		  selectedWeapon = "knife";
		  ourHero.setGold(ourHero.getGold()-15);
		  
	  }
    
    System.out.println("Good choice to pick a "+selectedWeapon+"!");
    requestsLocation();
  }

  private void enterZone6() throws InterruptedException {
    // change image
	  
    // ADD CODE HERE

    // describe the area/situation to the user.
	  int damage;
	  System.out.println("You are now in the Dungeon and ready to fight the Great Dragon!");

	  // Give them options for choices.
	  
	  System.out.print("Because you picked the "+selectedWeapon+", you deal ");
	  if (selectedWeapon.equalsIgnoreCase("bow and arrow")) {
		  damage = 15;
	  } else if (selectedWeapon.equalsIgnoreCase("sword")) {
		  damage = 25;
	  } else if (selectedWeapon.equalsIgnoreCase("knife")){
		  damage = 5;
	  } else {
		  damage = 1;
	  }
	  System.out.println(damage+" damage");
	  
	  System.out.println("\n\n The dragon spots you, and rushes to attack!");
	  Thread.sleep(100);
	  System.out.println("Do you");
	  System.out.println("1. throw your weapon");
	  System.out.println("2. grab your weapon and effectively use it ");
	  System.out.println("3. run");
	  String input;
	  input = inScanner.nextLine();
	  
	  if (input.equalsIgnoreCase("1")) {
		  System.out.println("You had barely effected its health! and now it strikes back!");
		  System.out.println("You have a 50/50 chance of life or death and now you regret throwing your weapon");
		  
		  if (Math.random()>.5) {
			  System.out.println("You had barely survived and the great dragon had spared your life, you need to go to the hospital!");
			  ourHero.setHealth(1);
			  checkUsersHealth();
		  } else {
			  System.out.println("You had bled out because you have no weapon");
			  
		  }
	  } else if (input.equalsIgnoreCase("2")) {
		 bossBattle(50,damage);
	  } else {
		  System.out.println("The dragon struck back and had ended your life! ");
		  ourHero.setHealth(0);
		  checkUsersHealth();
	  }


    
  }
  
  private void bossBattle(int dhp, int d) {
	  // this is part of the final boss battle
	  int numOfSwings=0;
	  System.out.println("You had used your weapon effectivly and now the dragons stunned!");
	  System.out.println("You need to find a way to properly secure the dragons death! ");
	  System.out.println("Your effectiveness of your attacks will be randomized!");
	  System.out.println("The dragons starting health is "+dhp+" hp!");
	  
	  System.out.println("# of swings: "+numOfSwings);
	  while (dhp>0) {
		  System.out.println("# of swings: "+numOfSwings);
		  if (Math.random()<.1) {
			  System.out.println("critical hit!");
			  dhp-=d;
		  } else {
			  System.out.println("you had missed!");
		  }
		  numOfSwings++;
		  
	  }
	  
	  System.out.println("Congrats! YOU HAD WON!");
	  System.out.println("The amount of gold you have is now set to be 100,000,000!");
	  ourHero.setGold(100000000);
	  
	  
  }
  private void requestsLocation() throws InterruptedException{
	  // method requests the users next location
	checkUsersHealth();
    String input;
    System.out.println("\nWhat would you like to do? "
    		+ "\ncity: go towards the city"
    		+ "\nforest: turn around and re-enter the forest"
    		+ "\ndesert: go to the desert"
    		+ "\nhospital: go to the hospital"
    		+ "\ndesert: go to the desert"
    		+ "\nmountain: go to the mountain"
    		+ "\ndungeon: go to the dungeon to fight the boss"
    		+ "\n" + ourHero.getName() + ": ");
    input = inScanner.nextLine();

    if (input.equalsIgnoreCase("city")){
      enterZone1();
    } else if (input.equalsIgnoreCase("forest") || input.equalsIgnoreCase("north")) {
    	enterZone2();
    } else if (input.equalsIgnoreCase("hospital")) {
    	enterZone4();
    } else if (input.equalsIgnoreCase("desert") || input.equalsIgnoreCase("south")) {
    	enterZone3();
    } else if (input.equalsIgnoreCase("mountain")) {
    	enterZone5();
    } else if (input.equalsIgnoreCase("Dungeon")) {
    	enterZone6();
    }
    
  }
  public void checkUsersHealth() {
	  // this method checks if the users health is above not less than 0
	  if (ourHero.getHealth()<=0) {
		  gameEnd();
	  }
  }

  private void gameEnd() {
    // This ends the game
	System.out.println("\n\n\nThe game has ended due to lack of health!");
	
    inScanner.close();
  }
}