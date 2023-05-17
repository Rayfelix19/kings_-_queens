package Game;

import java.util.Arrays;

public class Board {
	public Piece[][] board;
	public int whiteTurn;
	private int currentPieceLoc[];
	private PieceSet pieceSet;
	public Piece currentPiece;
	private GameManager manager;
	private boolean whiteCheck;
	private boolean blackCheck;
	private boolean whiteCheckmate;
	private boolean blackCheckmate;
	
	public Board(GameManager temp) {
		manager = temp;
		pieceSet = temp.pieceSet;
		whiteTurn = 0;
		board = new Piece[8][8];
		
		// pawns
		for (int i = 0; i < 8; i++ ) {
			board[1][i]= new Pawn(1, new int[] {1,i}, pieceSet);
			board[6][i]= new Pawn(0, new int[] {6,i}, pieceSet);
		}
		
		// queens
        board[7][3]= new Queen(0, new int[] {7,3}, pieceSet);
        board[0][3]= new Queen(1, new int[] {0,3}, pieceSet);
        
        // kings
        board[0][4] = new King(1, new int[] {0,4}, pieceSet);
        board[7][4] = new King(0, new int[] {7,4}, pieceSet);

		// rooks
        board[0][0] = new Rook(1, new int[] {0,0}, pieceSet);
        board[0][7] = new Rook(1, new int[] {0,7}, pieceSet);
        board[7][0] = new Rook(0, new int[] {7,0}, pieceSet);
        board[7][7] = new Rook(0, new int[] {7,7}, pieceSet);

		// knights
        board[0][1] = new Knight(1, new int[] {0,1}, pieceSet);
        board[0][6] = new Knight(1, new int[] {0,6}, pieceSet);
        board[7][1] = new Knight(0, new int[] {7,1}, pieceSet);
        board[7][6] = new Knight(0, new int[] {7,6}, pieceSet);

		// bishops
        board[0][2]= new Bishop(1, new int[] {0,2}, pieceSet);
        board[0][5]= new Bishop(1, new int[] {0,5}, pieceSet);
        board[7][2]= new Bishop(0, new int[] {7,2}, pieceSet);
        board[7][5]= new Bishop(0, new int[] {7,5}, pieceSet);
        
        manager.updateGUI(board);
	}
	
	public boolean isOccupied(int[] targetLoc) {
		return (board[targetLoc[0]][targetLoc[1]] != null);
	}
	
	public void placePiece(int buttonLoc[]){
		
		if(board[currentPieceLoc[0]][currentPieceLoc[1]].moveApp(buttonLoc, this)) {
		if(isOccupied(buttonLoc) && whiteTurn != board[buttonLoc[0]][buttonLoc[1]].getColor()) 
			capturePiece(buttonLoc);
		
		board[buttonLoc[0]][buttonLoc[1]] = board[currentPieceLoc[0]][currentPieceLoc[1]];
		
		board[currentPieceLoc[0]][currentPieceLoc[1]].setXnY(buttonLoc);
		board[currentPieceLoc[0]][currentPieceLoc[1]] = null;
		changeTurn();
		}
		manager.updateGUI(board);
	}
	
	public void changeTurn() {
		if(whiteTurn == 0) {
			whiteTurn = 1;
		}else whiteTurn = 0;
	}
	
	public boolean isBlocked() {
		
		return false;
	}
	
	public void capturePiece(int buttonLoc[]){
		board[buttonLoc[0]][buttonLoc[1]] = null;
	}
	
	public void setCurrentPiece(int buttonLoc[]) {
			currentPieceLoc = buttonLoc;
	}
	
}
