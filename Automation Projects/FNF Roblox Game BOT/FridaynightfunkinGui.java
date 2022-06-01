package com.Roblox.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

public class FridaynightfunkinGui {
	
	private JFrame frame;
	Timer t;
	int y = 182;
	Color blackColor;
	boolean isOn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FridaynightfunkinGui window = new FridaynightfunkinGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws AWTException 
	 * @throws InterruptedException 
	 */
	public FridaynightfunkinGui() throws AWTException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws AWTException 
	 * @throws InterruptedException 
	 */
	private void initialize() throws AWTException, InterruptedException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("On");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				isOn=true;
			}
		});
		btnNewButton.setBounds(64, 124, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOff = new JButton("Off");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOn=false;
			}
		});
		btnOff.setBounds(265, 124, 89, 23);
		frame.getContentPane().add(btnOff);
		
		JLabel lblNewLabel = new JLabel("Status: "+isOn);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		/*
		 * get xy coordinates of both sides of the 4 triangles
		 * grab RGB colors in the dead middle
		 * if they DON'T equal to the RGB color, HOLD THAT ARROW
		 * if they equal to the RGB color, un release the key
		 * */ 
		grabColors();
		
		// left side, 
		//322, 218 (136, 165, 171) LEFT DOWN UP RIGHT
		//542, 218 (136, 165, 171)
		//763, 218 (136, 165, 171)
		//989, 218
		
		// right side
		//1532, 218 (136, 165, 171)
		//1793, 218 (136, 165, 171)
		//2013, 218 (136, 165, 171)
		//2250, 218 (136, 165, 171)
		
		//y cord of the is 295 which shows the rgb of 0,0,0, if its not 000, don't release else release
		t = new Timer(3,(ActionEvent e)->{
			//grabXY();
			lblNewLabel.setText("Status: "+isOn);
			if (isOn) {
				try {
					grabColors();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		t.start();
		System.out.println();
	}
	
	
	
	
	/*
	 * 186, 120
	 * 301, 120
	 * 417, 120
	 * 532, 120
	 * */
	
	public void grabColors() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Color leftColor = new Color(194,75,153); 
		y=182;
		blackColor = new Color(0,0,0);
		
		Color grabPixelLocation1 = robot.getPixelColor(330,y);
		Color grabPixelLocation2 = robot.getPixelColor(545,y);
		Color grabPixelLocation3 = robot.getPixelColor(762,y);
		Color grabPixelLocation4 = robot.getPixelColor(989,y);
	
		if(leftColor.getRed()==grabPixelLocation1.getRed() ) {
			clickA();
			releaseA();
		} 
		if (leftColor.getRed()==grabPixelLocation2.getRed()) {
			clickS();
			releaseS();
		} 
		if (leftColor.getRed()==grabPixelLocation3.getRed()) {
			clickW();
			releaseW();
		}
		if (leftColor.getRed()==grabPixelLocation4.getRed()){
			clickD();
			releaseD();
		}
		
	/*	
		// HOLD COLOR = 194, 75, 153
		Color holdColor = new Color(194,75,153); 
		y=266;
		grabPixelLocation1 = robot.getPixelColor(322,y);
		grabPixelLocation2 = robot.getPixelColor(542,y);
		grabPixelLocation3 = robot.getPixelColor(763,y);
		grabPixelLocation4 = robot.getPixelColor(989,y);
		
		System.out.println(grabPixelLocation4.getRed()+" "+grabPixelLocation4.getGreen()+ " "+grabPixelLocation4.getBlue());
	
		if (grabPixelLocation1.getRGB()!=holdColor.getRGB() 
			|| grabPixelLocation1.getRGB() != leftColor.getRGB()) {
			releaseA();
		}
		if (grabPixelLocation2.getRGB()!=holdColor.getRGB() 
			|| grabPixelLocation2.getRGB() != leftColor.getRGB()) {
			releaseS();
		}
		if (grabPixelLocation3.getRGB()!=holdColor.getRGB() 
			|| grabPixelLocation3.getRGB() != leftColor.getRGB()) {
			releaseW();
		}
		if (grabPixelLocation4.getRGB()!=holdColor.getRGB() 
			|| grabPixelLocation4.getRGB() != leftColor.getRGB()) {
			releaseD();
		}
*/
	}

	
	public void clickW() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_W);
	    Thread.sleep(1);
	}
	public void clickA() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_A);
	    Thread.sleep(1);
	}
	public void clickS() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_S);
	    Thread.sleep(1);
	}
	public void clickD() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_D);
	    Thread.sleep(1);
	}
	
	
	
	
	public void releaseW() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyRelease(KeyEvent.VK_W);
	}
	public void releaseA() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyRelease(KeyEvent.VK_A);
	}
	
	public void releaseS() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyRelease(KeyEvent.VK_S);
	}
	public void releaseD() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyRelease(KeyEvent.VK_D);
	}
	
	public void grabXY() {
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;   
        System.out.println("X: "+mouseX+" Y:"+mouseY);

	}

}
