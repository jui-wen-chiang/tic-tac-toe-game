package tictactoe;

// Person 5:
public class Main {
    private static UIHandler ui;
    private static Player player1;
    private static Player player2;
    private static GameBoard board;
    private static GameLogic gameLogic;
    private static Player currPlayer;
    private static ComputerAI computerAI;

    public static void main(String[] args) {
        // Init ui, game board & logic
        ui = new UIHandler();
        board = new GameBoard();
        gameLogic = new GameLogic(board);

        ui.displayWelcome();

        // Ask for 1P/2P
        int gameMode = ui.getGameMode();

        // Player profile setup
        // P1
        String name1 = ui.getHumanName(1);
        char symbol1 = ui.getHumanSymbol(1);
        player1 = new Player(name1, symbol1, false);
        System.out.println("P1 set up: " + player1.getName() + " plays as " + player1.getSymbol());

        // P2 (forced to choose remaining symbol)
        char symbol2 = player1.getSymbol() == 'x' ? 'o' : 'x';
        if (gameMode == 1) {
            // Create CPU player
            player2 = new Player("SUPER CPU", symbol2, true);
            computerAI = new ComputerAI(board, gameLogic, player2.getSymbol(), player1.getSymbol());
        } else {
            String name2 = ui.getHumanName(2);
            player2 = new Player(name2, symbol2, false);
        }
        System.out.println("P2 set up: " + player2.getName() + " plays as " + player2.getSymbol() + "\n");

        // Game start/loop
        do {
            board.resetBoard();
            board.printBoard();

            // player with X goes first
            currPlayer = player1.getSymbol() == 'x' ? player1 : player2;

            gameLoop();
            ui.displayResults(gameLogic.isDraw(), currPlayer.getName());
        } while (ui.askPlayAgain());
        System.out.println("Thanks for playing!");
    }

    // Take turns
    private static Player switchTurn(Player currPlayer) {
        return currPlayer == player1 ? player2 : player1;
    }

    // Main game execution
    private static void gameLoop() {
        while (!gameLogic.isGameOver()) {
            if (currPlayer.isComputer()) {
                handleCPUTurn();
            } else {
                handlePlayerTurn();
            }
            board.printBoard();
            currPlayer = switchTurn(currPlayer);
        }
        // Game end > swap back (to the player making the winning move)
        currPlayer = switchTurn(currPlayer);
    }

    // CPU turn helper
    private static void handleCPUTurn() {
        int[] move = computerAI.handleAITurn();
        System.out.println(currPlayer.getName() + "'s turn (" + currPlayer.getSymbol() + "): [" + move[0] + ", " + move[1] + "]");
    }

    // Player turn helper
    private static void handlePlayerTurn() {
        int[] move = new int[2];
        boolean validMove = false;
        while (!validMove) {
            move = ui.getHumanMove(currPlayer.getName(), currPlayer.getSymbol());
            validMove = gameLogic.validateInput(move[0], move[1]);
        }
        board.placeSymbol(move[0], move[1], currPlayer.getSymbol());
    }
}
