public class TicTacToe {
    public static void main(String[] args) {
        Board a = new Board();
        int playCount = 0, player;
        do {
            if (playCount % 2 == 0) {
                player = 1;
            } else {
                player = 2;
            }
            a.collectInput(player);
            a.displayBoard();
            playCount++;
        } while (!a.checkWin() && playCount < 9);
        if (a.checkWin()) {
            System.out.println("Player" + player + " Wins");
        } else if (playCount == 9) {
            System.out.print("Tie");
        }
    }
}