import java.util.Scanner;

class TicTacToe {
    private char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    private int currentPlayer;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe ob = new TicTacToe();
        ob.play();
    }

    private void play() {
        currentPlayer = 1;
        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn");
            while (true) {
                int[] ar = input();
                if (checkValidMove(ar)) {
                    updateBoard(ar);
                    if (checkWin()) {
                        System.out.println("Player " + currentPlayer + " wins");
                        printBoard();
                        return;
                    }
                    if (checkTie()) {
                        System.out.println("Tie");
                        printBoard();
                        return;
                    }
                    if (currentPlayer == 1)
                        currentPlayer = 2;
                    else
                        currentPlayer = 1;
                    break;
                }
                System.out.println("Invalid move, try again.");
            }
        }
    }

    private void updateBoard(int[] ar) {
        char ch = currentPlayer == 1 ? 'X' : 'O';
        board[ar[0]][ar[1]] = ch;
    }

    private int[] input() {

        System.out.println("Enter row number");
        int r = sc.nextInt() - 1;
        System.out.println("Enter column number");
        int c = sc.nextInt() - 1;
        int[] mv = new int[2];
        mv[0] = r;
        mv[1] = c;
        return mv;
    }

    private boolean checkValidMove(int[] a) {
        int n = a[0], m = a[1];
        if (n < 3 && m < 3)
            if (board[n][m] == ' ')
                return true;
        return false;
    }

    private void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("---------");
        }
        System.out.println();
    }

    private boolean checkWin() {
        char ch = currentPlayer == 1 ? 'X' : 'O';
        return checkRows(ch) || checkDiagonals(ch) || checkColumns(ch);
    }

    private boolean checkRows(char ch) {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
                if (board[i][0] == ch)
                    return true;
        return false;
    }

    private boolean checkDiagonals(char ch) {
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2]) == board[1][1] && board[1][1] == board[2][0])
            if (board[1][1] == ch)
                return true;
        return false;
    }

    private boolean checkColumns(char ch) {
        for (int i = 0; i < 3; i++)
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
                if (board[0][i] == ch)
                    return true;
        return false;
    }

    private boolean checkTie() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

}
