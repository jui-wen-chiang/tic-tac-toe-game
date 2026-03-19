package tictactoe;

// Person 1:
public class GameBoard {
    // TODO: Declare a 4x4 char[][] array
    // TODO: Initialize all cells to empty (e.g. '-')
    // TODO: printBoard() — Display the current board state in a formatted layout
    // TODO: placeSymbol() — Place a symbol at the given (row, col) position
    // TODO: isEmpty() — Check if the specified cell is empty
    // TODO: isFull() — Check if all cells on the board are occupied
    // TODO: resetBoard() — Reset the board to its initial empty state
    // TODO: getCell() — Return the symbol at the specified cell

    private char[][] board;
    private int size; // 4

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];

        // Initialize all cells to empty '-'
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void printBoard() {
        // 0 1 2 3
        // 0 - - - -
        // 1 - - - -
        // 2 - - - -
        // 3 - - - -
    }
}
