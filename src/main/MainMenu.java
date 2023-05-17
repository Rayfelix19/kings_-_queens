package main;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Game.GameManager;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainMenu extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	MainMenu frame = new MainMenu();
	frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		
		
		setTitle("Kings & Queens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 590);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		new Audio();
		setContentPane(contentPane);
		contentPane.setLayout(null);

////////////////////////////////////////////////////////////////////////////////
		JButton btn_Play = new JButton("Play Game");
		contentPane.add(btn_Play);
		btn_Play.setBounds(70, 200, 100, 40);

		btn_Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameManager();
				dispose();
			}
		});
////////////////////////////////////////////////////////////////////////////////
		JButton btn_Settings = new JButton("Settings");
		contentPane.add(btn_Settings);
		btn_Settings.setBounds(300, 200, 100, 40);

		btn_Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
////////////////////////////////////////////////////////////////////////////////
		JButton btn_How = new JButton("How to Play");
		contentPane.add(btn_How);
		btn_How.setBounds(70, 350, 100, 40);

		btn_How.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
////////////////////////////////////////////////////////////////////////////////	
		JButton btn_Credits = new JButton("Credits");
		contentPane.add(btn_Credits);
		btn_Credits.setBounds(300, 350, 100, 40);

		btn_Credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
////////////////////////////////////////////////////////////////////////////////

		BufferedImage img;
		Image newImg = null;

		JLabel background = new JLabel();
		background.setBounds(0, 0, 471, 560);
		contentPane.add(background);
//image = ImageIO.read(getClass().getResource("/resources/icon.gif"));
		try {
			img = ImageIO.read(getClass().getResource("/res/KingNQueen.jpg"));
			newImg = img.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
			background.setIcon(new ImageIcon(newImg));
		} catch (IOException e) {
			System.out.println("File not found: " + e.getMessage());
		}

	}
}
