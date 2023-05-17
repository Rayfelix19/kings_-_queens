package Game;

public class King extends Piece {
	
	public King() {}

	public King(int color, int[] currentXY, PieceSet pieceset) {
		super(color, currentXY, pieceset);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean moveApp(int[] endPos, Board board) {
		int[] startPos = this.getXnY();
		
		// one at a time
		return Math.abs(startPos[0] - endPos[0]) <= 1 && Math.abs(startPos[1] - endPos[1]) <= 1;
	}
}
