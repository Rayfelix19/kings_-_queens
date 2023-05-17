package Game;
import java.awt.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameManager {

	private JFrame gameManager;

	private BufferedImage buffImg;
	public Board board;
	public PieceSet pieceSet = new PieceSet(0);
	private JPanel visual = new JPanel();
	private JButton[][] buttons = new JButton[8][8];
	
	// game state
	private Boolean isPieceSelected;
	private int[] chosenButton;
	private Piece chosenPiece;

	public GameManager() {

		isPieceSelected = false;
		gameManager = new JFrame("Kings & Queens");
		
		
		gameManager.setVisible(true);
		gameManager.setResizable(false);
		gameManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameManager.setBounds(100, 100, 487, 590);
		gameManager.getContentPane().setLayout(null);

		visual.setBackground(Color.BLACK);
		gameManager.getContentPane().add(visual);
		visual.setLocation(100, 100);
		visual.setBorder(null);
		visual.setBounds(60, 60, 350, 350);
		visual.setLayout(new GridLayout(8, 8, 0, 0));

		// add buttons to game visual
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// create a button with checker visual layout
				JButton btnNewButton = new JButton("");
				btnNewButton.setBorder(null);
				btnNewButton.setBackground((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0) ? Color.BLACK : Color.WHITE);
				
				// set the piece on the button

				// handle button presses
				int buttonLoc[] = {i,j};
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
							
							// set the chose piece
							// set the chosen button
							
							if (board.isOccupied(buttonLoc) && board.whiteTurn == board.board[buttonLoc[0]][buttonLoc[1]].getColor()) {
								
								chooseButton(buttonLoc);
								board.setCurrentPiece(buttonLoc);
								
							}else if(chosenButton != buttonLoc && chosenButton != null) {
								board.placePiece(buttonLoc);
								chosenButton = null;
							}
							
							 
							//board.placePiece(buttonLoc);
						
							// check if the move is valid and not blocked
							// move the piece from chosenButton to the currently clicked button aka 
							
						
						
						//if (board.setCurrentPiece(finalI, finalJ)) {
							// change color of button
						//System.out.println("Integer Value: " + String.valueOf(buttonLoc[0]) + " " + String.valueOf(buttonLoc[1]));
						
				}
					
				});
				
				
				// add the button to the grid layout
				visual.add(btnNewButton);
		}
		}
		
		board = new Board(this);
		
		JLabel greyBoard = new JLabel();
		greyBoard.setOpaque(true);
		greyBoard.setBackground(Color.LIGHT_GRAY);
		gameManager.getContentPane().add(greyBoard);
		greyBoard.setBounds(35, 35, 400, 400);
		gameManager.setVisible(true);
		
		JLabel background = new JLabel();
		background.setBounds(0, 0, 600, 600);
		gameManager.getContentPane().add(background);
		Image img;
//img = ImageIO.read(getClass().getResource("/res/KingNQueen.jpg"));
		try {
			buffImg = ImageIO.read(getClass().getResource("/res/background1.jpg"));
			img = buffImg.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
			background.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		
	}
	
	public void updateGUI(Piece[][] pieces) {

		int tally = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				buttons[i][j] = (JButton) visual.getComponent(tally);
				if(pieces[i][j] != null) {
					buttons[i][j].setIcon(new ImageIcon(pieces[i][j].getImage()));
				} else buttons[i][j].setIcon(null);
				tally++;
			}
		}
		if(chosenButton != null)
			endHighLight();
	}
	
	public void chooseButton(int loc[]) {
		if(chosenButton == null ) {
			buttons[loc[0]][loc[1]].setBackground(Color.YELLOW);
			chosenButton = loc;
			return;
		} 
		
		endHighLight();
		
		if(chosenButton != loc) {
			buttons[loc[0]][loc[1]].setBackground(Color.YELLOW);
			chosenButton = loc;
		} else chosenButton = null;
	}
	
	public void endHighLight() {
		if(chosenButton[0] % 2 != 0) {
			if(chosenButton[1] % 2 == 0) {
				buttons[chosenButton[0]][chosenButton[1]].setBackground(Color.WHITE);
			} else buttons[chosenButton[0]][chosenButton[1]].setBackground(Color.BLACK);
		} else {
			if(chosenButton[1] % 2 == 0) {
			buttons[chosenButton[0]][chosenButton[1]].setBackground(Color.BLACK);
		} else buttons[chosenButton[0]][chosenButton[1]].setBackground(Color.WHITE);	
		}
	}
}
