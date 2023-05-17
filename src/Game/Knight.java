package Game;

public class Knight extends Piece{
	
	public Knight() {}

	public Knight(int color, int[] currentXY, PieceSet pieceset) {
		super(color, currentXY, pieceset);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Boolean moveApp(int[] endPos, Board board) {
		int[] startPos = this.getXnY();
		
		// up/down 1 over 2 || up/down 2 over 1
		return (startPos[0] == endPos[0] - 2 || startPos[0] == endPos[0] + 2) && (startPos[1] == endPos[1] - 1 || startPos[1] == endPos[1] + 1) || (startPos[0] == endPos[0] - 1 || startPos[0] == endPos[0] + 1) && (startPos[1] == endPos[1] - 2 || startPos[1] == endPos[1] + 2);
	}
}
