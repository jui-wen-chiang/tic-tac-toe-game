package tictactoe;

// Person 1:
public class GameBoard {

    private char[][] board;
    private int size; // 3

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (int col = 0; col < size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void placeSymbol(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == '-';
    }

    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return size;
    }
}
