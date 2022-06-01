package com.zzg.main;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
* version 1.0
* 
* Project created by: Dave Ruth .. Niles North High School .. 
* 
* ~~~~~~~~~~~~~~~~~ Clone of classic game ZigZag ~~~~~~~~~~~~~~<br>
* <p>
* This game is implemented as a simple JPanel embedded in a JFrame<br>
* with a Timer for animation. <br>
* 
* <xmp><code><pre>
* Task 0:
* compile and run JZigZag.
* 
* 
* Task 1 .. //initializing 
* 
* Create an instance variable called track that is an ArrayList of Integers
* In method initRound() ... initialize track to a new ArrayList and
* add the following 22 Integers: [1,2,3,4,5,6,5,6,5,6,7,6,7,8,7,6,5,4,3,2,1,0]
* (0 thru 8 represent the nine possible horizontal positions for the track pieces)
* 
* Create instance variables ballX and ballY ... for the x and y coordinates
* of the ball .. initially set to coordinates (200,350)
* 
* In method draw() ... g.drawImage(ballImg, ballX-10, ballY-10, null);
* 
* ~~~ You should see the ball ~~~
* 
* 
* Task 2 .. //draw the track
* 
* Create an instance variable called
* trackImg and initialize it similar to ballImg (use file track.png)
* 
* 
* Write a for loop and draw the trackImg (similar to ballImg)
* every 20 pixels .. along the y axis and 
* at track.get(i) multiplied by 40 pixels .. along the x axis
* 
* ~~~ You should see the initial track ~~~
* 
* 
* Task 3 .. // get things to move
* 
* Now, add frameCount % 20 to the y coordinate of each trackImg
* 
* In method actionPerformed() ... if frameCount % 20 is 19, remove the last
* element of List track and add it to the beginning of List track
* 
* ~~~ (.. hit 'b' to start the game ..) You should see the track move ~~~
* 
* 
* Create instance variable xVelocity which has value 2
* (..fun Geometry fact.. slope is 1/2 .. rise over run .. 
*  ball x coord moves by 2 for every track y coord moves by 1 .. )
* 
* In method actionPerformed() ... increase ballX by xVelocity
* 
* In method keyPressed() ... change the sign of the xVelocity variable
*   when the space key is pressed
* 
* ~~~ You should see the track and ball move ~~~ 
* 
* 
* Task 4 .. // game over code
* 
* In method actionPerformed() ... 
*   stop the timer if the ball falls off the track
* 
* ~~~ This can be tricky, please read this carefully ~~~
* 
* Remember, ballY is always at 350 and since the ball radius is 10,
*  the bottom of the ball has y coord 360...
* 
* A track piece top is a rhombus with height 40 and width 80
*  and is moving down one pixel per frame
* 
* Create two instance variables:
*   private int leftBound, leftBoundIncrement;
*   
* In method initRound()
*   assign them values of 162 and 2 respectively
*   (note: 162 is approximately 40 pixels to the left of ballX)
*   
* In method actionPerformed()
*   In the if(frameCount % 20 == 19) block
*     check if (track.get(16) > track.get(17))
*     // note: track.get(17) is the one that spans over y coord 350
*     //       and track.get(16) is the one above it
*     //       this means the next piece the ball will roll on is
*     //       to the right of the current piece it is rolling on
*     assign leftBoundIncrement a value of positive 2
*     otherwise, leftBoundIncrement gets a value of negative 2
*   Now, increase leftBound by leftBoundIncrement
*   
*   if the ballX is not within the range [leftBound,leftBound+80]
*     then stop the timer
*   
*  ~~optional~~ In method draw()
*    Uncomment the line with g.drawLine(
* 
* 
* Task 5 .. // random track
* 
* Create an instance variable called extraTrack that is an ArrayList of Integers
* In method initRound() ... initialize track to a new ArrayList
*  and add write a loop to add 500 Integer values, each between 0 and 8 inclusive
* You should be familiar by now with the 9 horizontal positions for the track pieces
* 
* ... Here is one simple way ...
* In method initRound() ...
*   Begin with the value of the first element of List track
*   int currentValue = track.get(0);
*   if the currentValue is either 0 or 8 (..at an edge..), add the appropriate 1 or 7
*   TO THE BEGINNING of List extraTrack, 
*   otherwise choose randomly to add either currentValue+1 or currentValue-1
* 
* In method actionPerformed() ...
*   Locate the code where you remove and add an element from List track
*   Leave the code that removes the last element of List track
*   Now, remove the appropriate element from List extraTrack and 
*   add it to the appropriate place in List track
* 
* Discuss with your classmates and teacher some interesting ways to generate a 
* random sequence of track pieces that will be fun and challenging for the player
* 
* Task 6 .. // hi score
* 
* Create an instance variable hiScore=0 that is not initialized in initGame()
* that is assigned the score (i.e. frameCount/20) 
* if the current score is greater than hiScore 
* and display it next to the current score in method draw()
* 
* ~~optional~~ in method actionPerformed() after frameCount++
*    if (frameCount % 400 == 0) // every 400 frames
*      timer.setDelay(timer.getDelay() - 1); // speed up the timer
* 
* ==========================================================================
*      CONGRATULATIONS! YOU HAVE CREATED YOUR OWN ADDICTING GAME!
* ==========================================================================
* 
*/
public class JZigZag extends JPanel implements KeyListener, ActionListener {

 // YOUR CODE GOES HERE..
 // declare all instance variables here
 private ArrayList<Integer> track;
 private ArrayList<Integer> extraTrack;
 public static final Rectangle BORDER = new Rectangle(0, 0, 400, 700);
 private int frameCount;// used for the score
 private String title = "~~ JZigZag ~~  "
     + "CONTROLS: \'B\' to Start ~~ Space to Turn ~~";
 private Timer timer;// handles animation
 private static Image offScreenBuffer;// needed for double buffering graphics
 private Graphics offScreenGraphics;// needed for double buffering graphics

 private BufferedImage ballImg;
 private BufferedImage trackImg;
 private BufferedImage deadImg;
 private BufferedImage background;
 private BufferedImage rasputia;
 // private ArrayList<BufferedImage> screamImg;
 private ArrayList<String> talk;
 private int ballX=200;
 private int ballY=350;
 
 private int xVelocity = 2;
 
 
 private int leftBound, leftBoundIncrement;
 
 
 
 private int highScore;
 private boolean deathMessage;
 // private ArrayList <AudioClip> sound1;  
 
 
 /**
  * main() is needed to initialize the window.<br>
  * THIS METHOD SHOULD NOT BE MODIFIED! ..
  */
 public static void main(String[] args) {
   JFrame window = new JFrame("Imposter JWalkin");
   window.setBounds(100, 100, BORDER.width + 7, BORDER.height + 30);
   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   window.setResizable(false);

   JZigZag game = new JZigZag();
   window.getContentPane().add(game);
   window.setVisible(true);
   game.init();
   window.addKeyListener(game);
 }

 /**
  * init method needed to initialize certain fields and load resources
  */
 public void init() {
   offScreenBuffer = createImage(getWidth(), getHeight());// should be 800x400
   offScreenGraphics = offScreenBuffer.getGraphics();
   timer = new Timer(30, this);
   // screamImg = new ArrayList<BufferedImage>();
   // timer fires every 30 milliseconds.. invokes method actionPerformed()
   // 1,2,3,4,5,6,5,6,5,6,7,6,7,8,7,6,5,4,3,2,1,0
   talk = new ArrayList<String>();
   talk.add("I can do better bindfolded");
   talk.add("Is this your first time?");
   talk.add("maybe this isn't for you");
   talk.add("did you even try?");
   talk.add("L");
   // sound1 = new ArrayList<AudioClip>();
   try {
     
     ballImg = ImageIO.read(getClass().getResource("ball.PNG"));
     trackImg = ImageIO.read(getClass().getResource("track.PNG"));
     deadImg= ImageIO.read(getClass().getResource("dead-body.PNG"));
     background = ImageIO.read(getClass().getResource("background2.PNG"));
     rasputia= ImageIO.read(getClass().getResource("unknown.PNG"));
   } catch (IOException ex) {
      ex.printStackTrace();
   }

   initRound();
 }

 /**
  * initializes all fields needed for each round of play (i.e. restart)
  */
 public void initRound() {
     
   frameCount = 0;
   leftBound=162;
   leftBoundIncrement=2;
   // YOUR CODE GOES HERE..
   // initialize instance variables here
   
   int[] nums = {1,2,3,4,5,6,5,6,5,6,7,6,7,8,7,6,5,4,3,2,1,0};
   track = new ArrayList<Integer>();
   for(int i = 0;i<nums.length;i++){
       track.add(nums[i]);
   }
   

   extraTrack = new ArrayList<Integer>();
   int currentValue = track.get(0);
   for(int i = 0;i<500;i++) {
       if(currentValue==0) {
           extraTrack.add(1);
           
       } else if(currentValue==8) {
           extraTrack.add(7);
           
       } else {
           if(Math.random()>.5) {
               currentValue+=1;
           } else {
               currentValue-=1;
           }
           
       }
       
       
       
   }
   
   ballX=leftBound+40;
   ballY=360;

   repaint();
 }

 /**
  * Called automatically after a repaint request<br>
  * THIS METHOD SHOULD NOT BE MODIFIED! ..
  */
 public void paint(Graphics g) {
   draw((Graphics2D) offScreenGraphics);
   g.drawImage(offScreenBuffer, 0, 0, this);
   
 }

 /**
  * renders all objects to Graphics g
  */
 

 public void draw(Graphics2D g) {
   
 
   g.fill(BORDER);// paint background

   
   if (!timer.isRunning()) {
     g.drawString(title, 10, 600);// draw title when not playing
   }
   
   

   

   // YOUR CODE GOES HERE..
   // render all game objects here
   //g.drawLine(ballX, ballY + 10, leftBound + 80, ballY + 10);
   
   int s = 0;
   g.drawImage(background,0,0,null);
   for(int i = 0;i<400;i+=20){
      if(track!=null){
           if(s<=track.size()){
             
             g.drawImage(trackImg,track.get(s)*40,i+(frameCount%20),null);
             
             s++;
           } 
      }
     }
     
   g.drawImage(ballImg,ballX-10,ballY-10,null);
   Music m = new Music();
   if(deathMessage){
       int random = (int)(Math.random()*3);
       g.setFont(new Font("TimesRoman", Font.PLAIN, 16)); 
       g.setColor(new Color(255,255,255));
       g.drawString("You had died with a score of only "+frameCount/20+", "+talk.get(random),0,575);
       g.drawImage(deadImg,100,300,null);
       m.playSound("fart.wav");
		
       
       
   } 
   
   if(Math.random()<=.0125) {
	   m.playSound("AHH.wav");
   }
   if(Math.random()<=.04) {
	   g.drawImage(rasputia,0,0,null);
   }


       
   
   
 }

 /**
  * Called automatically when the timer fires<br>
  * this is where all the game fields will be updated
  */
 public void actionPerformed(ActionEvent e) {

   // YOUR CODE GOES HERE..
   // update all game variables here
   
   ballX+=xVelocity;
   
   if(frameCount%20==19){
       int temp = track.get(track.size()-1);
       track.remove(track.size()-1);
       track.add(0,temp);
       
       if(track.get(16)>track.get(17)){
           leftBoundIncrement=2;
       } else {
           leftBoundIncrement=-2;
       }
      

   }
   leftBound+=leftBoundIncrement;
   
   if(ballX>=leftBound+80 || ballX<=leftBound) {
       timer.stop();
       deathMessage=true;
   }    


   frameCount++;// used for the score
   if(frameCount%400==0) {
       if(timer.getDelay()>=5) {
           timer.setDelay(timer.getDelay()-5);
       }
   }
   repaint();// needed to refresh the animation
 }

 /**
  * handles any key pressed events and updates the ball xVelocity by changing
  * the sign of the xVelocity variable
  */
 public void keyPressed(KeyEvent e) {
   int keyCode = e.getKeyCode();
   if (keyCode == KeyEvent.VK_SPACE) {
     xVelocity*=-1;

   }
 }

 /**
  * handles any key released events restarts the game if the Timer is not
  * running and user hits 'B' key
  */
 public void keyReleased(KeyEvent e) {
   int keyCode = e.getKeyCode();
   if (keyCode == KeyEvent.VK_B) {
     if (!timer.isRunning()) {
       if(frameCount>0){
          deathMessage=!deathMessage;
       }
       timer.start();
       initRound();

           
     }
   }
 }

 /**
  * this method is needed for implementing interface KeyListener<br>
  * THIS METHOD SHOULD NOT BE MODIFIED! ..
  */
 public void keyTyped(KeyEvent e) {
 }

}// end class JZigZag





