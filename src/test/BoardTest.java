package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Game;
import source.Move;
import source.Player;

public class BoardTest {
	Player player1, player2;
	Board board;
	Move move;
	Game game;

	@Before
	public void beforeAll() {
		player1 = new Player("X", "human");
		player2 = new Player("O", "human");
		board = new Board();
		game = new Game(board, player1, player2);
		move = new Move(0, 0);
	}

	@Test
	public void boardIsEmptyWhenInstantiated() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				assertEquals("", board.getSpace(row, col));
				assertNotNull(board.getSpace(row, col));
			}
		}
	}

	@Test
	public void isValidMoveReturnTest() {
		assertTrue(board.isValidMove(move));

		board.update("X", move);

		assertFalse(board.isValidMove(move));
	}

	@Test
	public void toStringReturnsNicelyFormattedBoard() {
		String boardView = board.toString();
		String expected = "[][][]\n[][][]\n[][][]";
		assert (boardView.equals(expected));
	}

	@Test
	public void copyConstructedBoardDoesNotUpdateOriginalBoard() {
		Board clone = board.copy();
		clone.update("X", move);

		assertEquals("", board.getSpace(0, 0));
		assertEquals("X", clone.getSpace(0, 0));
	}

	@Test
	public void winHorizontallyReturnsTrueForWinnerByRow() {
		for (int col = 0; col < 3; col++) {
			move.row = 0;
			move.col = col;
			board.setSpace(move.row, move.col, "X");
		}

		assertEquals(true, board.isWinnerHorizontally("X"));
	}

	@Test
	public void winVerticallyReturnsTrueForWinnerByColumn() {
		for (int row = 0; row < 3; row++) {
			board.setSpace(row, 0, "X");
		}

		assertEquals(true, board.isWinnerVertically("X"));
	}

	@Test
	public void winDiagonallyReturnsTrueForTopLeftToBottomRightWin() {
		for (int space = 0; space < 3; space++) {
			move.row = space;
			move.col = space;
			board.setSpace(space, space, "X");
		}

		assertEquals(true, board.isWinnerDiagonally("X"));
	}

	@Test
	public void winDiagonallyReturnsTrueForTopRightToBottomLeftWin() {
		move.row = 0;
		move.col = 2;
		board.update("X", move);

		move.row = 1;
		move.col = 1;
		board.update("X", move);

		move.row = 2;
		move.col = 0;
		board.update("X", move);

		assertTrue(board.isWinnerDiagonally("X"));
	}

	@Test
	public void getAvailableMovesReturnsAllMovesForEmptyBoard() {
		ArrayList<Move> moves = board.getAvailableMoves();
		assertEquals(9, moves.size());
	}

	@Test
	public void getAvailableMovesLeavesOutMarkedSpaces() {
		move.row = 0;
		move.col = 0;
		game.takeTurn(player1, move);

		ArrayList<Move> moves = board.getAvailableMoves();

		assertEquals(8, moves.size());
	}

	@Test
	public void isDrawReturnsTrueWhenAllSpacesTakenAndNoWinner() {
		board = generateDrawState();
		assertTrue(board.isDraw());
	}

	@Test
	public void isGameOverReturnsTrueWhenThereIsAWinnerOrDraw() {
		board = generateDrawState();
		assertTrue(board.isGameOver());
	}

	@Test
	public void isGameOverReturnsFalseWhenNoWinnerAndNoDraw() {
		assertEquals(false, board.isGameOver());
	}

	@Test
	public void availableMovesIsEmptyInDrawState() {
		board = generateDrawState();
		assertTrue(board.getAvailableMoves().isEmpty());
	}

	public Board generateDrawState() {
		Board board = new Board();

		board.setSpace(0, 0, "X");
		board.setSpace(0, 1, "X");
		board.setSpace(1, 2, "X");
		board.setSpace(2, 0, "X");
		board.setSpace(2, 2, "X");
		board.setSpace(0, 2, "O");
		board.setSpace(1, 0, "O");
		board.setSpace(1, 1, "O");
		board.setSpace(2, 1, "O");

		return board;
	}
}
