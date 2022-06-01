package com.fh.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ForzaGrindGui {

	private JFrame frame;
	static boolean isOn;
	Timer t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		KeyPress.main(null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForzaGrindGui window = new ForzaGrindGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForzaGrindGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Timer(500,(ActionEvent e)->{
			if(isOn) {
				frame.setBackground(Color.GREEN);
			} else {
				frame.setBackground(Color.RED);
			}
		});
		t.start();
	}	
}
