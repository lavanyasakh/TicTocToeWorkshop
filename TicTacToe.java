import java.util.*;
public class TicTacToe {

    //Static ArrayVariable
    public static char[] board = new char[10];
	 public static char personChoice, compChoice;

    //CreateBoard() method to initialise a char array of size 10 
    public static void createBoard() {
        for (int i = 1; i < 10; i ++) {
            board[i] = ' ';
        }
    }

	//playerChoice() method to choose Person's and Computer's choice 
	public static void playerChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose letter 'X' or 'O': ");
		personChoice = sc.next().charAt(0);
		if ( personChoice == 'X' || personChoice == 'x') {
			personChoice = 'X';
			compChoice = 'O';
		}
		else {
			personChoice = 'O';
			compChoice = 'X';
		}
		System.out.println("User: "+personChoice+"\nComputer: "+compChoice);
	}



    public static void main(String[] args) {
        createBoard();
		  playerChoice();
    }
}
