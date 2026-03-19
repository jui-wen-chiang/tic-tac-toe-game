package tictactoe;

public class Player {
    private String name;
    private char symbol; // 'X' or 'O'
    private boolean isComputer;

    public Player(String name, char symbol, boolean isComputer) {
        this.name = name;
        this.symbol = symbol;
        this.isComputer = isComputer;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }
}
