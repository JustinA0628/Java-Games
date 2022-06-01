package com.zzg.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Menu extends Music {
	public static void main(String[] args) {
		JFrame frame = new JFrame("NOT AMONG US");
		JZigZag game = new JZigZag();
		Music m = new Music();

		frame.setBounds(450, 600, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(new Color(0, 0,0));
		frame.setVisible(true);
		
		JLabel lbl = new JLabel("PRESS ONLINE TO START PLAYING ZIGZAG");
		lbl.setBackground(Color.WHITE);
		lbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(0, 398, 195, 163);
		frame.getContentPane().add(lbl);
		
		
		Icon icon;
		icon = new ImageIcon("C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\src\\com\\zzg\\main\\among us.png");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(0,0,800,600);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.main(null);
				frame.setVisible(false);
				m.playSound("sfx-boing9.wav");
			}
		});
		button.setBounds(322, 372, 133, 67);
		frame.getContentPane().add(button);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
	}
}
