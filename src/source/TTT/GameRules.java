package source.TTT;

public class GameRules {
	private Board board;

	public GameRules(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isValidMove(Position move) {
		return (board.getSpace(move.row, move.col).equals(""));
	}

	public boolean isValidMoveAsString(String move) {
		Position position = new Position(move);
		return (isValidMove(position));
	}

	public boolean isWinnerHorizontally(String marker) {
		boolean winner = false;

		for (int row = 0; row < 3; row++) {
			if (board.getSpace(row, 0).equals(marker)
					&& board.getSpace(row, 1).equals(marker)
					&& board.getSpace(row, 2).equals(marker))
				winner = true;
		}

		return winner;
	}

	public boolean isWinnerVertically(String marker) {
		boolean winner = false;

		for (int col = 0; col < 3; col++) {
			if (board.getSpace(0, col).equals(marker)
					&& board.getSpace(1, col).equals(marker)
					&& board.getSpace(2, col).equals(marker))
				winner = true;
		}

		return winner;
	}

	public boolean isWinnerDiagonally(String marker) {
		boolean winner = false;
		if (board.getSpace(0, 0).equals(marker)
				&& board.getSpace(1, 1).equals(marker)
				&& board.getSpace(2, 2).equals(marker))
			winner = true;

		if (board.getSpace(0, 2).equals(marker)
				&& board.getSpace(1, 1).equals(marker)
				&& board.getSpace(2, 0).equals(marker))
			winner = true;

		return winner;
	}

	public boolean isWinner(String marker) {
		return isWinnerHorizontally(marker) || isWinnerVertically(marker)
				|| isWinnerDiagonally(marker);
	}

	public boolean isDraw() {
		return (board.getAvailablePositions().isEmpty() && !isWinner("X") && !isWinner("O"));
	}

	public boolean isGameOver() {
		return (isWinner("X") || isWinner("O") || isDraw());
	}
}
