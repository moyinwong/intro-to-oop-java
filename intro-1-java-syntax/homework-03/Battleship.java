import java.util.Arrays;
import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");
		System.out.println();

		char[][] player1Board = new char[5][5];
		char[][] player2Board = new char[5][5];
		char[][] player1HistoryBoard = new char[5][5];
		char[][] player2HistoryBoard = new char[5][5];

		initBoard(player1HistoryBoard);
		initBoard(player2HistoryBoard);

		int[][] board = new int[5][5];

		promptAndPopulatePlayerBoard("PLAYER 1", player1Board, scanner);
		promptAndPopulatePlayerBoard("PLAYER 2", player2Board, scanner);

		int turn = 0;
		int player1ShipCount = 5;
		int player2ShipCount = 5;
		do {
			int player = turn % 2 == 0 ? 1 : 2;
			int opponent = turn % 2 == 0 ? 2 : 1;

			char[][] currentPlayerHistoryBoard = player == 1 ? player1HistoryBoard : player2HistoryBoard;
			char[][] opponentBoard = player == 1 ? player2Board : player1Board;

			System.out.printf("Player %d, enter hit row/column:\n", player);

			int x = scanner.nextInt();
			int y = scanner.nextInt();

			while (isCoordinateOutOfBoard(x, y, player1Board)) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				System.out.printf("Player %d, enter hit row/column:\n", player);
				x = scanner.nextInt();
				y = scanner.nextInt();
			}

			while (isAlreadyFiredAtSameSpot(x, y, currentPlayerHistoryBoard)) {
				System.out.println("You already fired on this spot. Choose different coordinates.");
				System.out.printf("Player %d, enter hit row/column:\n", player);
				x = scanner.nextInt();
				y = scanner.nextInt();
			}

			if (isMissed(x, y, opponentBoard)) {
				System.out.printf("PLAYER %d MISSED!\n", player);
				markAsMissed(x, y, currentPlayerHistoryBoard);
				markAsMissed(x, y, opponentBoard);
			} else if (isHit(x, y, opponentBoard)) {
				System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!\n", player, opponent);
				markAsHit(x, y, currentPlayerHistoryBoard);
				markAsHit(x, y, opponentBoard);

				if (turn % 2 == 0) {
					player2ShipCount--;
				} else {
					player1ShipCount--;
				}
			}

			printBattleShip(currentPlayerHistoryBoard);
			if (player1ShipCount > 0 && player2ShipCount > 0) {
				System.out.println();
			}
			turn++;
		} while (player1ShipCount > 0 && player2ShipCount > 0);

		System.out.printf("PLAYER %d WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n", player2ShipCount == 0 ? 1 : 2);
		System.out.println();
		System.out.println("Final boards:");
		System.out.println();

		printBattleShip(player1Board);
		System.out.println();
		printBattleShip(player2Board);
	}

	private static void promptAndPopulatePlayerBoard(String player, char[][] board, Scanner scanner) {
		System.out.printf("%s, ENTER YOUR SHIPS' COORDINATES.\n", player);

		initBoard(board);

		for (int i = 0; i < board.length; i++) {
			System.out.printf("Enter ship %d location:\n", i + 1);
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			while (isCoordinateOutOfBoard(x, y, board)) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				System.out.printf("Enter ship %d location:\n", i + 1);
				x = scanner.nextInt();
				y = scanner.nextInt();
			}

			while (board[x][y] == '@') {
				System.out.println("You already have a ship there. Choose different coordinates.");
				System.out.printf("Enter ship %d location:\n", i + 1);
				x = scanner.nextInt();
				y = scanner.nextInt();
			}

			board[x][y] = '@';
		}

		printBattleShip(board);
		print100Lines();
	}

	private static boolean isHit(int x, int y, char[][] opponentBoard) {
		return opponentBoard[x][y] == '@';
	}

	private static void markAsHit(int x, int y, char[][] board) {
		board[x][y] = 'X';
	}

	private static boolean isMissed(int x, int y, char[][] opponentBoard) {
		return opponentBoard[x][y] != '@';
	}

	private static void markAsMissed(int x, int y, char[][] board) {
		board[x][y] = 'O';
	}

	private static boolean isAlreadyFiredAtSameSpot(int x, int y, char[][] board) {
		return board[x][y] == 'X' || board[x][y] == 'O';
	}

	private static boolean isCoordinateOutOfBoard(int x, int y, char[][] board) {
		return x >= board.length || y >= board.length || x < 0 || y < 0;
	}

	private static void initBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				board[row][col] = '-';
			}
		}
	}

	private static void print100Lines() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}