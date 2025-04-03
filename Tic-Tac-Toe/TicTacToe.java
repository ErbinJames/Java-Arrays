import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        //declare and initialize a 3x3 board
        char[][] board = new char[3][3];
        initializedBoard(board);

        //declare a current player
        char currentPlayer = 'X';

        boolean gameRunning = true;

        System.out.println("Tic-Tac-Toe Game");
        while(gameRunning) {
            displayBoard(board); // show the board

            //prompt the user for input
            System.out.println();//new line
            System.out.print("Player " + currentPlayer + ", enter row and column (1-3): ");
            int row = scanner.nextInt() - 1;// converted to 0-based index
            int col = scanner.nextInt() - 1;
            
            //validating input
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '_') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            //place the move
            board[row][col] = currentPlayer;

            //check for a win
            if (checkWin(board)) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameRunning = false;
            }

            //check for a draw
            else if (isDraw(board)){
                displayBoard(board);
                System.out.println("It's a draw!");
                gameRunning = false;
            }
            // switch player
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        //close the scanner
        scanner.close();
    }
    // method to initialize the board with '_'
    public static void initializedBoard(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }
    // method to display the board
    public static void displayBoard(char[][] board) {
        System.out.println("\n  1 2 3"); //column numbers
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " "); // row numbers
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();// new line
        }
    }
    // method to check the winner
    public static boolean checkWin(char[][] board) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if(board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2] ) {
                return true; //row match
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '_' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true; // Column match
            }
        }
        // Check main diagonal
        if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true; // Main diagonal match
        }
        // Check secondary diagonal
        if (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true; // Secondary diagonal match
        }
        return false; // No winner yet
    }
    // method to check if the board is full (draw)
    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return false; // if empty cell is found, its not draw
                }
            }
        }
        return true;
    }

}
