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

	//displayBoard() method to Display the  TicTacToe  Board
	public static void displayBoard() {
		System.out.println("  " + board[1] + " | "+ board[2] + " | " + board[3] + "  ");
		System.out.println("--------------");
		System.out.println("  " + board[4] + " | "+ board[5] + " | " + board[6] + "  ");
		System.out.println("--------------");
		System.out.println("  " + board[7] + " | "+ board[8] + " | " + board[9] + "  ");
	}

	//playerPlay() method To Check Whether The Position Is Empty Or Not
	public static void playerPlay() {
		Scanner sc = new Scanner(System.in);
		System.out.println(personChoice + " Play First Enter Slot Number From 1 To 9 ");
		while (true) {
			int number = sc.nextInt();
			if (number > 0 && number < 10) {
				if (board[number] == ' ') {
					board[number] = personChoice;
					break;
				}
				else
					System.out.println("Position Occupies Already");
			}
			else
				System.out.println("InValid Input Number");
		}
	}
	public static void main(String[] args) {
		createBoard();
		playerChoice();
		displayBoard();
		playerPlay();
	}
}
