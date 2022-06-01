package com.zzg.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 600, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
	
		frame.setBackground(new Color(0, 0,0));
		frame.setVisible(true);
		JLabel lblNewLabel_1 = new JLabel("PRESS ONLINE TO START PLAYING ZIGZAG");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 398, 195, 163);
		frame.getContentPane().add(lblNewLabel_1);
		Icon icon;
		icon = new ImageIcon("C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\src\\com\\zzg\\main\\among us.png");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(0,0,800,600);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(322, 372, 133, 67);
		frame.getContentPane().add(btnNewButton);
		
		

		
		
	}
}
