package com.Roblox.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

// 2560x1440 res
/*
 330 208
 545
 762
 138
 */

public class NewFridayNightFunkin {
	static Timer t;
	public static boolean grabColor(int x, int y) throws AWTException {
		Color pColor = new Color(194,75,153);
		Robot robot = new Robot();
		Color grabPixelLocation1 = robot.getPixelColor(x,y);
		if(pColor.getRGB()==grabPixelLocation1.getRGB()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		t = new Timer(2,(ActionEvent e)->{
			try {
				if(grabColor(330,208)) {
					// left
					clickA();
					System.out.println("a");
				} 
				
				if(grabColor(545,208)) {
					// down
					clickS();
				}
				
				if(grabColor(762,208)) {
					// up
					clickW();
				}
				
				if(grabColor(138,208)) {
					// right
					clickD();
				}
				
				
				
				
				
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		t.start();
	}
	
	
	
	
	
	
	
	
	public static void clickW() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_W);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_W);
	}
	public static void clickA() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_A);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_A);
	}
	public static void clickS() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_S);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_S);
	}
	public static void clickD() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_D);
	    Thread.sleep(1);
	    robot.keyRelease(KeyEvent.VK_D);
	}
}
