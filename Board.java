import java.util.Scanner;

public class Board {
    private char[][] board = new char[3][3];

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x')
                    || (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o')) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if ((board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x')
                    || (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o')) {
                return true;
            }
        }
        if ((board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x')
                || board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') {
            return true;
        }
        if ((board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x')
                || (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')) {
            return true;
        }
        return false;
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    if (board[i][j] != 'x' && board[i][j] != 'o') {
                        System.out.print("\t\t|");
                    } else {
                        System.out.print("\t" + board[i][j] + "\t|");
                    }
                } else {
                    if (board[i][j] != 'x' && board[i][j] != 'o') {
                        System.out.println("\t\t");
                        if (i < 2) {
                            for (int k = 0; k < 52; k++) {
                                System.out.print("-");
                            }
                            System.out.println("-");
                        }
                    } else {
                        System.out.println("\t" + board[i][j]);
                        if (i < 2) {
                            for (int k = 0; k < 52; k++) {
                                System.out.print("-");
                            }
                            System.out.println("-");
                        }
                    }
                }
            }
        }
    }

    public void collectInput(int player) {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("Player" + player + " enter co-ordinates:");
        x = input.nextInt() - 1;
        y = input.nextInt() - 1;
        // input.close();
        if (board[x][y] != 'x' && board[x][y] != 'o') {
            if (player == 1) {
                board[x][y] = 'x';
            } else if (player == 2) {
                board[x][y] = 'o';
            }
        } else {
            System.out.println(" Space is already filled try again");
            collectInput(player);
        }
    }
}