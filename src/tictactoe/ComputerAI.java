package tictactoe;

import java.util.Arrays;

// Rene Vincent Quiambao - 101585336
public class ComputerAI {
    private GameBoard board;
    private GameLogic logic;
    private char aiSymbol;
    private char playerSymbol;

    public ComputerAI(GameBoard board, GameLogic logic, char aiSymbol, char playerSymbol) {
        this.board = board;
        this.logic = logic;
        this.aiSymbol = aiSymbol;
        this.playerSymbol = playerSymbol;
    }
    
    //
    // hi call this to make the AI play their turn
    // i will comment this class properly another time :D
    //
    public int[] handleAITurn() {
        int[] move = findBestMove();
        board.placeSymbol(move[0], move[1], aiSymbol);
        return move;
    }

    public int[] findBestMove() {
        int best = -9999;
        int[] bestMove = {-1, -1};
        int[][] moves = collectEmptyCells();
        
        for (int[] move : moves) {
            board.placeSymbol(move[0], move[1], aiSymbol);

            int moveValue = minimax(0, false, -9999, 9999);

            board.placeSymbol(move[0], move[1], '-');

            if (moveValue > best) {
                best = moveValue;
                bestMove[0] = move[0];
                bestMove[1] = move[1];
            }   
        }
        return bestMove;
    }

    public int evaluate() {
        char winner = logic.hasWinner();
        
        if (winner == aiSymbol) return 10;
        if (winner == playerSymbol) return -10;
        return 0;
    }

    public int minimax(int depth, boolean aiTurn, int alpha, int beta) {
        int score = evaluate();

        if (score == 10) return score - depth;
        if (score == -10) return score + depth;
        if (board.isFull()) return 0;

        if (aiTurn) {
            int best = -9999;
            int[][] moves = collectEmptyCells();

            for (int[] move : moves) {
                board.placeSymbol(move[0], move[1], aiSymbol);

                best = Math.max(best, minimax(depth + 1, !aiTurn, alpha, beta));

                board.placeSymbol(move[0], move[1], '-');

                alpha = Math.max(alpha, best);
                if (beta <= alpha) break;
            }
            return best;
        }
        else {
            int best = 9999;
            int[][] moves = collectEmptyCells();

            for (int[] move : moves) {
                board.placeSymbol(move[0], move[1], playerSymbol);

                best = Math.min(best, minimax(depth + 1, !aiTurn, alpha, beta));

                board.placeSymbol(move[0], move[1], '-');

                beta = Math.min(beta, best);
                if (beta <= alpha) break;
            }
            return best;
        }
    }

    public int[][] collectEmptyCells() {
        int size = board.getSize();
        int[][] empty = new int[size * size][2];
        int count = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.isEmpty(row, col)) {
                    empty[count] = new int[]{row, col};
                    count++;
                }
            }
        }
        return Arrays.copyOf(empty, count);
    }
}
