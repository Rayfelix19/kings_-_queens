package Game;

public class Pawn extends Piece{

	public Pawn() {}

	public Pawn(int color, int[] currentXY, PieceSet pieceset) {
		super(color, currentXY, pieceset);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean moveApp(int[] endPos, Board board) {
		
		int color = this.getColor();
		int[] startPos = this.getXnY();
		
		// use to check if the piece if the piece is moving forward one or two
		int moveOne = color == 0 ? startPos[0]-1 : startPos[0]+1;
		int moveTwo = color == 0 ? startPos[0]-2 : startPos[0]+2;
		int pawnStart = color == 0 ? 6 : 1;
		
		// move up 1 or 2 on first move, 1 up if no piece is there, 1 diag if enemy is there
		if(moveOne == endPos[0] || (startPos[0] == pawnStart && moveTwo == endPos[0])) {
			// diag
			if(startPos[1] != endPos[1]) {
				// cant move more than one to left or right
				if(Math.abs(startPos[1] - endPos[1]) != 1) {
					return false;
				}
				
				if(!board.isOccupied(endPos)) {
					return false;
				} 
			} else if(board.isOccupied(endPos)) {
				// cant move forward if piece is occupying
				return false;
			}
		} else {
			return false;
		}
		
		return true;
	}

}
