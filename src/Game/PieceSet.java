package Game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PieceSet {
	
	private int currentPieceSet;
	private Image img[] = new Image[12];
	
	public PieceSet(int currentPieceSet) {
		this.currentPieceSet = currentPieceSet;
		//BufferedImage img;
		
		/*try {
			img = ImageIO.read(new File("background/background.gif"));
		} catch (IOException e)) {
			System.out.println("File not found: " + e.getMessage());
		}*/
		
		String temp = new String();
		switch (this.currentPieceSet)
		{
		    case 0:
		    	temp = "holywarriors";
		    	break;
		    case 1:
		    	temp = "basic";
		    	break;
		}
			//(getClass().getResource("/res/KingNQueen.jpg")
		try {
			img[0]= ImageIO.read(getClass().getResource("/res/WP.gif"));
			img[1]= ImageIO.read(getClass().getResource("/res/BP.gif"));
			img[2]= ImageIO.read(getClass().getResource("/res/WR.gif"));
			img[3]= ImageIO.read(getClass().getResource("/res/BR.gif"));
			img[4]= ImageIO.read(getClass().getResource("/res/WN.gif"));
			img[5]= ImageIO.read(getClass().getResource("/res/BN.gif"));
			img[6]= ImageIO.read(getClass().getResource("/res/WB.gif"));
			img[7]= ImageIO.read(getClass().getResource("/res/BB.gif"));
			img[8]= ImageIO.read(getClass().getResource("/res/WQ.gif"));
			img[9]= ImageIO.read(getClass().getResource("/res/BQ.gif"));
			img[10]= ImageIO.read(getClass().getResource("/res/WK.gif"));
			img[11]= ImageIO.read(getClass().getResource("/res/BK.gif"));
			
			/*img[0]= ImageIO.read(getClass().getResource("/resources/chesspieces/" + temp + "/WP.gif"));
			img[1]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/BP.gif"));
			img[2]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/WR.gif"));
			img[3]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/BR.gif"));
			img[4]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/WN.gif"));
			img[5]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/BN.gif"));
			img[6]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/WB.gif"));
			img[7]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/BB.gif"));
			img[8]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/WQ.gif"));
			img[9]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/BQ.gif"));
			img[10]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/WK.gif"));
			img[11]= ImageIO.read(new File("./resources/chesspieces/" + temp + "/BK.gif"));
			*/
		} catch (IOException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		
	}
	
	public Image getImage(int color, String target) {
		int val = 0;
		
		if(target.equals(new Pawn().getClass().toString())) {
	    	val = color == 0 ? 0 : 1;
		} else if(target.equals(new Rook().getClass().toString())) {
	    	val = color == 0 ? 2 : 3;
		} else if(target.equals(new Knight().getClass().toString())) {
	    	val = color == 0 ? 4 : 5;
		} else if(target.equals(new Bishop().getClass().toString())) {
	    	val = color == 0 ? 6 : 7;
		} else if(target.equals(new Queen().getClass().toString())) {
	    	val = color == 0 ? 8 : 9;
		} else if(target.equals(new King().getClass().toString())) {
	    	val = color == 0 ? 10 : 11;
		}
		
		return img[val];
	}

}
