package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Board;
import source.TTT.GameRules;
import source.TTT.Player;
import source.TTT.Position;

public class GameRulesTest {
	Player player1, player2;
	GameRules rules;
	Board board;
	Position move;

	@Before
	public void beforeAll() {
		player1 = new Player("X", "human");
		player2 = new Player("O", "human");
		board = new Board();
		move = new Position(0, 0);
	}

	@Test
	public void isValidMoveReturnTest() {
		assertTrue(GameRules.isValidMove(move, board));

		board.setSpace(move.row, move.col, player1.getMarker());

		assertFalse(GameRules.isValidMove(move, board));
	}

	@Test
	public void winHorizontallyReturnsTrueForWinnerByRow() {
		for (int col = 0; col < 3; col++) {
			move.row = 0;
			move.col = col;
			board.setSpace(move.row, move.col, "X");
		}

		assertEquals(true, GameRules.isWinnerHorizontally("X", board));
	}

	@Test
	public void winVerticallyReturnsTrueForWinnerByColumn() {
		for (int row = 0; row < 3; row++) {
			board.setSpace(row, 0, "X");
		}

		assertEquals(true, GameRules.isWinnerVertically("X", board));
	}

	@Test
	public void winDiagonallyReturnsTrueForTopLeftToBottomRightWin() {
		for (int space = 0; space < 3; space++) {
			move.row = space;
			move.col = space;
			board.setSpace(space, space, "X");
		}

		assertEquals(true, GameRules.isWinnerDiagonally("X", board));
	}

	@Test
	public void winDiagonallyReturnsTrueForTopRightToBottomLeftWin() {
		move.row = 0;
		move.col = 2;
		board.setSpace(move, "X");

		move.row = 1;
		move.col = 1;
		board.setSpace(move, "X");

		move.row = 2;
		move.col = 0;
		board.setSpace(move, "X");

		assertTrue(GameRules.isWinnerDiagonally("X", board));
	}

	@Test
	public void isDrawReturnsTrueWhenAllSpacesTakenAndNoWinner() {
		board = generateDrawState();
		assertTrue(GameRules.isDraw(board));
	}

	@Test
	public void isGameOverReturnsTrueWhenThereIsAWinnerOrDraw() {
		board = generateDrawState();
		assertTrue(GameRules.isGameOver(board));
	}

	@Test
	public void isGameOverReturnsFalseWhenNoWinnerAndNoDraw() {
		assertEquals(false, GameRules.isGameOver(board));
	}

	@Test
	public void availableMovesIsEmptyInDrawState() {
		board = generateDrawState();
		assertTrue(board.getAvailablePositions().isEmpty());
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
