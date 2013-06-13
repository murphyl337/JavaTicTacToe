package source;

import java.util.ArrayList;

import source.Move;

public class Board {
	public String[][] state = new String[3][3];

	public Board() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				state[row][col] = "";
		}
	}

	public Board copy() {
		Board copy = new Board();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				copy.state[row][col] = this.state[row][col];
		}
		return copy;
	}

	public void update(String marker, Move move) {
		state[move.row][move.col] = marker;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + state[row][col] + "]");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public ArrayList<Move> getAvailableMoves() {
		ArrayList<Move> availableMoves = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (state[row][col].equals("")) {
					Move move = new Move(row, col);
					availableMoves.add(move);
				}
			}
		}
		return availableMoves;
	}

	public boolean isWinner(String marker) {
		return isWinnerHorizontally(marker) || isWinnerVertically(marker)
				|| isWinnerDiagonally(marker);
	}

	public boolean isWinnerHorizontally(String marker) {
		boolean winner = false;

		for (int row = 0; row < 3; row++) {
			if (state[row][0].equals(marker) && state[row][1].equals(marker)
					&& state[row][2].equals(marker))
				winner = true;
		}

		return winner;
	}

	public boolean isWinnerVertically(String marker) {
		boolean winner = false;

		for (int col = 0; col < 3; col++) {
			if (state[0][col].equals(marker) && state[1][col].equals(marker)
					&& state[2][col].equals(marker))
				winner = true;
		}

		return winner;
	}

	public boolean isWinnerDiagonally(String marker) {
		boolean winner = false;
		if (state[0][0].equals(marker) && state[1][1].equals(marker)
				&& state[2][2].equals(marker))
			winner = true;

		if (state[0][2].equals(marker) && state[1][1].equals(marker)
				&& state[2][0].equals(marker))
			winner = true;

		return winner;
	}

	public boolean isDraw() {
		boolean draw = false;
		if (getAvailableMoves().isEmpty() && !isWinner("X") && !isWinner("O"))
			draw = true;
		return draw;
	}

	public boolean isGameOver() {
		boolean over = false;
		if (isWinner("X") || isWinner("O") || isDraw())
			over = true;
		return over;
	}

	public boolean isValidMove(Move move) {
		boolean valid = false;
		if (state[move.row][move.col].equals(""))
			valid = true;
		return valid;
	}

}
