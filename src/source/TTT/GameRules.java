package source.TTT;

public class GameRules {
	public static boolean isValidMove(Position move, Board board) {
		return (board.getSpace(move.row, move.col).equals(""));
	}

	public static boolean isValidMoveAsString(String move, Board board) {
		Position position = new Position(move);
		return (isValidMove(position, board));
	}

	public static boolean isWinnerHorizontally(String marker, Board board) {
		boolean winner = false;

		for (int row = 0; row < 3; row++) {
			if (board.getSpace(row, 0).equals(marker)
					&& board.getSpace(row, 1).equals(marker)
					&& board.getSpace(row, 2).equals(marker))
				winner = true;
		}

		return winner;
	}

	public static boolean isWinnerVertically(String marker, Board board) {
		boolean winner = false;

		for (int col = 0; col < 3; col++) {
			if (board.getSpace(0, col).equals(marker)
					&& board.getSpace(1, col).equals(marker)
					&& board.getSpace(2, col).equals(marker))
				winner = true;
		}

		return winner;
	}

	public static boolean isWinnerDiagonally(String marker, Board board) {
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

	public static boolean isWinner(String marker, Board board) {
		return isWinnerHorizontally(marker, board) || isWinnerVertically(marker, board)
				|| isWinnerDiagonally(marker, board);
	}

	public static boolean isDraw(Board board) {
		return (board.getAvailablePositions().isEmpty() && !isWinner("X", board) && !isWinner("O", board));
	}

	public static boolean isGameOver(Board board) {
		return (isWinner("X", board) || isWinner("O", board) || isDraw(board));
	}
}
