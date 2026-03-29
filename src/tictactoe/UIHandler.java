package tictactoe;

import java.util.Scanner;

// Person 2: 
public class UIHandler {
    public Scanner sc;
    // Initialize scanner once for the whole class

    public UIHandler() {
        sc = new Scanner(System.in);
    }
    // Displays the ASCII art welcome screen and game title

    public void displayWelcome(){
        System.out.println("  _____ _        _____             _____          ");
        System.out.println(" |_   _(_)__    |_   _|_ _ __    |_   _|__   ___ ");
        System.out.println("   | | | / _|    | |/ _` / _|     | |/ _ \\ / _ \\");
        System.out.println("   | | | \\__    | | (_| \\__ \\    | | (_) |  __/");
        System.out.println("   |_| |_|___/   |_|\\__,_|___/    |_|\\___/ \\___|");
        System.out.println();
        System.out.println("  *** Welcome to Tic Tac Toe! ***");
    }
    // Asks the user for game mode (1 or 2 players)
    // Returns 1 for one player, 2 for two players
    // Repeats if input is invalid
    public int getGameMode(){
        System.out.println("One or Two players?");
        String PlayerChoice = sc.nextLine().toLowerCase();
        if(PlayerChoice.equals("one") || PlayerChoice.equals("1")){
            System.out.println("one player");
            return 1;
        }else if(PlayerChoice.equals("two") || PlayerChoice.equals("2")){
            System.out.println("two players");
            return 2;
        }else {
            System.out.println("Invalid Choice");
        }
        return getGameMode();// ask again if invalid

    }
    // Collects name and symbol for each player based on game mode
    // gameMode 1 = one player, gameMode 2 = two players
    public void createHumanPlayer(int gameMode) {
        int numPlayers = (gameMode == 1) ? 1 : 2;

        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter name for Player " + i + ": ");
            String name = sc.nextLine();
            System.out.println("Enter symbol for Player " + i + " (X or O): ");
            String symbol = sc.nextLine();
        }
    }
    // Prompts the user to enter a row and column for their move
    // Validates that input is a number and within bounds (0-2)
    // Returns the move as an int array [row, col]
    public int[] getHumanMove() {
        try {
            System.out.println("Enter row (0-2): ");
            int row = Integer.parseInt(sc.nextLine());
            System.out.println("Enter column (0-2): ");
            int col = Integer.parseInt(sc.nextLine());

            // Check if move is within the board boundaries
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid move, try again.");
                return getHumanMove(); // ask again if out of bounds
            }
            return new int[]{row, col};
        } catch (NumberFormatException e) {
            // Catches non-numeric input and asks again
            System.out.println("Please enter a number!");
            return getHumanMove();
        }
    }
    // Displays the result of the game
    // Shows ASCII art for draw or winner
    // winnerName is only displayed if isDraw is false
    public void displayResults(boolean isDraw, String winnerName){
        if(isDraw){
            System.out.println("  ____  ____      ___        __");
            System.out.println(" |  _ \\|  _ \\    / \\ \\      / /");
            System.out.println(" | | | | |_) |  / _ \\ \\ /\\ / / ");
            System.out.println(" | |_| |  _ <  / ___ \\ V  V /  ");
            System.out.println(" |____/|_| \\_\\/_/   \\_\\_/\\_/   ");
        }else{
            System.out.println(" __        _____ _   _ _   _ _____ ____  ");
            System.out.println(" \\ \\      / /_ _| \\ | | \\ | | ____|  _ \\ ");
            System.out.println("  \\ \\ /\\ / / | ||  \\| |  \\| |  _| | |_) |");
            System.out.println("   \\ V  V /  | || |\\  | |\\  | |___|  _ < ");
            System.out.println("    \\_/\\_/  |___|_| \\_|_| \\_|_____|_| \\_\\");
            System.out.println(winnerName + " wins!");

        }
    }
    // Asks the user if they want to play again
    // Returns true if yes, false if no
    public boolean askPlayAgain() {
        System.out.println("Would you like to play again? y/n ");
        String input = sc.nextLine().toLowerCase();

        if (input.equals("y")) return true;
        else return false;
    }
}
