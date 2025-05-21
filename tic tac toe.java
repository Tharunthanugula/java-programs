import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🎮 Welcome to Tic Tac Toe!");

        boolean playAgain;
        do {
            initializeBoard();
            playGame();
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    // Initializes the board with empty spaces
    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    // Prints the current board
    static void printBoard() {
        System.out.println("\nCurrent board:");
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            if (i < 2) System.out.println("\n  ---------");
        }
        System.out.println();
    }

    // Main game loop
    static void playGame() {
        char currentPlayer = 'X';
        int moves = 0;
        boolean gameWon = false;

        while (moves < 9 && !gameWon) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");
            int row = getValidInput("Enter row (0-2): ");
            int col = getValidInput("Enter column (0-2): ");

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                moves++;
                gameWon = checkWin(currentPlayer);

                if (gameWon) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                } else if (moves == 9) {
                    printBoard();
                    System.out.println("🤝 It's a draw!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("❌ Cell already taken! Try again.");
            }
        }
    }

    // Gets a valid row or column input from user
    static int getValidInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                } else {
                    System.out.println("⚠️ Invalid input. Please enter 0, 1, or 2.");
                }
            } else {
                System.out.println("⚠️ That's not a number!");
                scanner.next(); // discard invalid input
            }
        }
    }

    // Checks if the current player has won
    static boolean checkWin(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // row
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))   // column
                return true;

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||     // diagonal
            (board[0][2] == player && board[1][1] == player && board[2][0] == player))       // anti-diagonal
            return true;

        return false;
    }
}
