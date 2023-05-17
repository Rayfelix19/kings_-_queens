package Game;

public class Rook extends Piece {
	
	public Rook() {}

	public Rook(int color, int[] currentXY, PieceSet pieceset) {
		super(color, currentXY, pieceset);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean moveApp(int[] endPos, Board board) {
		int[] startPos = this.getXnY();
		
		// is left/right || up/down
		return startPos[0] == endPos[0] || startPos[1] == endPos[1];
	}
}
