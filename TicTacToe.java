import java.util.*;
public class TicTacToe {
	//Static ArrayVariable
	public static char[] board = new char[10];
	public static char personChoice, compChoice;
	public static String result;

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
				else {
					System.out.println("Position Occupies Already");
					continue;
				}
			}
			else {
				System.out.println("InValid Input Number");
				continue;
			}
		}
	}
	public static void compPlay() {
		while (true) {
			int random = (int)(Math.floor(Math.random() * 10) % 9)+1;
			if (board[random] == ' ') {
				board[random] = compChoice;
				break;
			}
			else
				continue;
		}
	}

	public static boolean tossToKnow(){
		int random = (int)Math.floor(Math.random() * 10) % 2;
		if ( random == 0) {
			System.out.println(personChoice + " play first");
			return true;
		}
		else {
			System.out.println(compChoice + "play first");
			return false;
		}
	}
	/*WinnerCheck() method is to check either X or O has won the game or the game is draw */
	static String winnerCheck() {
		for (int j = 0; j < 8; j++) {
			switch (j) {
				case 0:
					result = new StringBuilder().append(board[1]).append(board[2]).append(board[3]).toString();
					break;
				case 1:
					result = new StringBuilder().append(board[4]).append(board[5]).append(board[6]).toString();
					break;
				case 2:
					result = new StringBuilder().append(board[7]).append(board[8]).append(board[9]).toString();
					break;
				case 3:
					result = new StringBuilder().append(board[1]).append(board[4]).append(board[7]).toString();
					break;
				case 4:
					result = new StringBuilder().append(board[2]).append(board[5]).append(board[8]).toString();
					break;
				case 5:
					result = new StringBuilder().append(board[3]).append(board[6]).append(board[9]).toString();
					break;
				case 6:
					result = new StringBuilder().append(board[1]).append(board[5]).append(board[9]).toString();
					break;
				case 7:
					result = new StringBuilder().append(board[3]).append(board[5]).append(board[7]).toString();
					break;
			}
			//If Winner Is X
			if (result.equals("XXX")) 
				return "X";

			//If Winner Is O
			else if (result.equals("OOO")) 
				return "O";
            
		}
		// In case of No-Winner 
		for (int i = 0; i < board.length; i++) {
			if (board[i] == ' ') {
				return null;
			}
		}
		return "draw";
	}
    // displayWinner method Prints The Winner Or Draw
    public static void displayWinner (String outPut) {
        if (outPut == "draw") {
            System.out.println("It Is Draw");
            System.exit(0);
        }
        else if(outPut == "X" || outPut == "O"){
            System.out.println("The winner is : " + outPut);
            System.exit(0);
        }
    }



	public static void main(String[] args) {
		String winner = null;
		createBoard();
		playerChoice();
		displayBoard();
		boolean get = tossToKnow();
		if (get){
			while (winner == null) {
				playerPlay();
				displayBoard();
				winner = winnerCheck();
				displayWinner(winner);
				System.out.println();
				compPlay();
				displayBoard();
				winner = winnerCheck();
				displayWinner(winner);
			}
		}
		else {
			while (winner == null) {
				compPlay();
				displayBoard();
				winner = winnerCheck();
				displayWinner(winner);
				System.out.println();
				playerPlay();
				displayBoard();
				winner = winnerCheck();
				displayWinner(winner);
			}
		}		
	}

}
