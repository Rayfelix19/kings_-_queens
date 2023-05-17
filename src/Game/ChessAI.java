package Game;

public class ChessAI {

}
/*NOT MY WORK, USED TO TRACING AND STUDYING





public class ChessAI {
    private int maxDepth;
    private int[][] board;
    private final int INF = 10000000; // A large number to represent infinity

    public ChessAI(int[][] board, int maxDepth) {
        this.board = board;
        this.maxDepth = maxDepth;
    }

    // The main function to select the best move
    public int[] selectMove() {
        int[] move = new int[4]; // Store the selected move in the format {fromX, fromY, toX, toY}
        int bestScore = -INF;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y] != 0 && board[x][y] < 7) { // Only consider moves for the white pieces
                    int[][] moves = generateMoves(x, y);

                    for (int[] m : moves) {
                        int fromX = x;
                        int fromY = y;
                        int toX = m[0];
                        int toY = m[1];

                        int tmp = board[toX][toY];
                        board[toX][toY] = board[fromX][fromY];
                        board[fromX][fromY] = 0;

                        int score = minimax(maxDepth, -INF, INF, false);

                        board[fromX][fromY] = board[toX][toY];
                        board[toX][toY] = tmp;

                        if (score > bestScore) {
                            bestScore = score;
                            move[0] = fromX;
                            move[1] = fromY;
                            move[2] = toX;
                            move[3] = toY;
                        }
                    }
                }
            }
        }

        return move;
    }

    // The minimax algorithm with alpha-beta pruning
    private int minimax(int depth, int alpha, int beta, boolean maximizingPlayer) {
        if (depth == 0) {
            return evaluate();
        }

        if (maximizingPlayer) {
            int maxScore = -INF;
            int[][] moves = generateMoves();

            for (int[] m : moves) {
                int fromX = m[0];
                int fromY = m[1];
                int toX = m[2];
                int toY = m[3];

                int tmp = board[toX][toY];
                board[toX][toY] = board[fromX][fromY];
                board[fromX][fromY] = 0;

                int score = minimax(depth - 1, alpha, beta, false);

                board[fromX][fromY] = board[toX][toY];
                board[toX][toY] = tmp;

                maxScore = Math.max(maxScore, score);
                alpha = Math.max(alpha, score);

                if (beta <= alpha) {
                    break;
                }
            }

            return maxScore;
        } else {
            int minScore = INF;
            int[][] moves = generateMoves();

            for (int[] m : moves) {
                int fromX = m[0];
                int fromY = m[1];
                int toX = m[2];
                int toY = m[3];

                int tmp = board[toX][toY];
                board[toX][toY] = board[fromX][fromY];
                board[fromX][fromY] = 0;

                int score = minimax(depth - 

*/