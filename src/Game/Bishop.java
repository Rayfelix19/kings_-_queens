package Game;

public class Bishop extends Piece {

	public Bishop() {}
	
	public Bishop(int color, int[] currentXY, PieceSet pieceset) {
		super(color, currentXY, pieceset);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean moveApp(int[] endPos, Board board) {
		int[] startPos = this.getXnY();
		
		// is diag
		return Math.abs(startPos[0] - endPos[0]) == Math.abs(startPos[1] - endPos[1]);
	}
}
