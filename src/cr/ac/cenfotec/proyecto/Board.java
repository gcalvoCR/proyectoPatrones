package cr.ac.cenfotec.proyecto;

public class Board extends Game {

	private static final int ROWS = 8;
	private static final int COLUMNS = 8;

	private Cell[][] board;

	public Board() {
		board = new Cell[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = new Cell(i, j);
			}
		}
	}

	@Override
	public void fillBoard() {
		CheckerType Black = CheckerType.BLACK;
		CheckerType Red = CheckerType.RED;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][0].getX() == 0 || board[i][0].getX() == 2) {
					board[i][1].setChecker(Black);
					board[i][3].setChecker(Black);
					board[i][5].setChecker(Black);
					board[i][7].setChecker(Black);
				}
				if (board[i][0].getX() == 1) {
					board[i][0].setChecker(Black);
					board[i][2].setChecker(Black);
					board[i][4].setChecker(Black);
					board[i][6].setChecker(Black);
				}
				if (board[i][0].getX() == 6) {
					board[i][1].setChecker(Red);
					board[i][3].setChecker(Red);
					board[i][5].setChecker(Red);
					board[i][7].setChecker(Red);
				}
				if (board[i][0].getX() == 5 || board[i][0].getX() == 7) {
					board[i][0].setChecker(Red);
					board[i][2].setChecker(Red);
					board[i][4].setChecker(Red);
					board[i][6].setChecker(Red);
				}
			}
		}

	}

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("     0   1   2   3   4   5   6   7  ");
		output.append("\n");
		output.append("   ---------------------------------");
		output.append("\n");

		for (int i = 0; i < ROWS; i++) {
			output.append(" " + i + " |");
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j].getChecker() == null) {
					output.append("   |");
				} else {
					output.append(" " + board[i][j].getChecker().toString().charAt(0) + " |");
				}
			}
			output.append("\n");
			output.append("   ---------------------------------");
			output.append("\n");
		}

		return output.toString();
	}

	@Override
	public void movePiece() {
		// TODO Auto-generated method stub

	}

}
