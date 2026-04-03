package tictactoe;

// Jui-Wen Chiang - 101571949
public class GameLogic {
    private GameBoard board;

    public GameLogic(GameBoard board) {
        this.board = board;
    }

    // Check all rows for 3 in a row
    public char checkHorizontal() {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            char first = board.getCell(row, 0);
            if (first == '-') continue;
            boolean win = true;
            for (int col = 1; col < size; col++) {
                if (board.getCell(row, col) != first) {
                    win = false;
                    break;
                }
            }
            if (win) return first;
        }
        return '-';
    }

    // Check all columns for 3 in a row
    public char checkVertical() {
        int size = board.getSize();
        for (int col = 0; col < size; col++) {
            char first = board.getCell(0, col);
            if (first == '-') continue;
            boolean win = true;
            for (int row = 1; row < size; row++) {
                if (board.getCell(row, col) != first) {
                    win = false;
                    break;
                }
            }
            if (win) return first;
        }
        return '-';
    }

    // Check both diagonals for 3 in a row
    public char checkDiagonal() {
        int size = board.getSize();

        // Top-left to bottom-right
        char first = board.getCell(0, 0);
        if (first != '-') {
            boolean win = true;
            for (int i = 1; i < size; i++) {
                if (board.getCell(i, i) != first) {
                    win = false;
                    break;
                }
            }
            if (win) return first;
        }

        // Top-right to bottom-left
        first = board.getCell(0, size - 1);
        if (first != '-') {
            boolean win = true;
            for (int i = 1; i < size; i++) {
                if (board.getCell(i, size - 1 - i) != first) {
                    win = false;
                    break;
                }
            }
            if (win) return first;
        }

        return '-';
    }

    // Combine all checks; return winning symbol or '-' if no winner
    public char hasWinner() {
        char result;

        result = checkHorizontal();
        if (result != '-') return result;

        result = checkVertical();
        if (result != '-') return result;

        result = checkDiagonal();
        if (result != '-') return result;

        return '-';
    }

    // Return true if board is full and there is no winner
    public boolean isDraw() {
        return board.isFull() && hasWinner() == '-';
    }

    // Return true if game has ended (winner or draw)
    public boolean isGameOver() {
        return hasWinner() != '-' || isDraw();
    }

    // Check if the input is within range and the cell is not occupied
    public boolean validateInput(int row, int col) {
        int size = board.getSize();
        if (row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("Invalid input: row and column must be between 0 and " + (size - 1) + ".");
            return false;
        }
        if (!board.isEmpty(row, col)) {
            System.out.println("Invalid input: cell (" + row + ", " + col + ") is already occupied.");
            return false;
        }
        return true;
    }
}