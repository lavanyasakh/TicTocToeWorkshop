public class TicTacToe {

    //Static ArrayVariable
    public static char[] board = new char[10];

    //CreateBoard() method to initialise a char array of size 10 
    public static void createBoard() {
        for (int i = 1; i < 10; i ++) {
            board[i] = ' ';
        }
    }

    public static void main(String[] args) {
        createBoard();
    }
}
