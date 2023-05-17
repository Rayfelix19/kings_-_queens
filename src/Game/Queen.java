package Game;

public class Queen extends Piece {
	
	public Queen() {}

	public Queen(int color, int[] currentXY, PieceSet pieceset) {
		super(color, currentXY, pieceset);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean moveApp(int[] endPos, Board board) {
		int[] startPos = this.getXnY();
		
		// rook or bishop movement
		return (startPos[0] == endPos[0] || startPos[1] == endPos[1]) || (Math.abs(startPos[0] - endPos[0]) == Math.abs(startPos[1] - endPos[1]));
	}
}
