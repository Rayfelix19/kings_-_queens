package Game;

import java.awt.Image;

public abstract class Piece {
 private int color;
 private int currentXY[];
 private Image pieceImage;
 
 public Piece() {}
 
 public Piece(int color, int currentXY[], PieceSet pieceSet) {
	 this.color = color;
	 this.currentXY = currentXY;
	 pieceImage = pieceSet.getImage(color, this.getClass().toString());
 }
 
 public void setXnY(int[] xy) {
   this.currentXY = xy;
 }
 
 public int[] getXnY() {
   return currentXY;
 }
 
 public Image getImage() {
   return pieceImage;
 }
 
 public int getColor() {
   return color;
 } 
 
 public abstract Boolean moveApp(int[] endPos, Board board);
 
}
