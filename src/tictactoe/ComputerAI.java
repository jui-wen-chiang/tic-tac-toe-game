package tictactoe;

import java.util.Random;

// Person 4:
public class ComputerAI {
    // empty cells are represented by '-'
    // TODO: collectEmptyCells() — Scan the board and store all empty cell coordinates into a temporary array
    // TODO: chooseMove() — Randomly select one position from the empty cells array
    // TODO: getRow() — Return the row of the AI's chosen move
    // TODO: getCol() — Return the column of the AI's chosen move
    // TODO: handleAITurn() — Execute the AI's turn and place its symbol on the board

    private Random rand;

    public ComputerAI() {
        rand = new Random();
    }
}
