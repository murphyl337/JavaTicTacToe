package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Game;
import source.GameRules;
import source.Move;
import source.Player;

public class GameRulesTest {
	Player player1, player2;
	GameRules rules;
	Board board;
	Move move;

	@Before
	public void beforeAll() {
		player1 = new Player("X", "human");
		player2 = new Player("O", "human");
		board = new Board();
		rules = new GameRules(board);
		move = new Move(0, 0);
	}

	@Test
	public void isValidMoveReturnTest() {
		assertTrue(rules.isValidMove(move));

		board.setSpace(move.row, move.col, player1.getMarker());

		assertFalse(rules.isValidMove(move));
	}

	@Test
	public void winHorizontallyReturnsTrueForWinnerByRow() {
		for (int col = 0; col < 3; col++) {
			move.row = 0;
			move.col = col;
			board.setSpace(move.row, move.col, "X");
		}

		assertEquals(true, rules.isWinnerHorizontally("X"));
	}

	@Test
	public void winVerticallyReturnsTrueForWinnerByColumn() {
		for (int row = 0; row < 3; row++) {
			board.setSpace(row, 0, "X");
		}

		assertEquals(true, rules.isWinnerVertically("X"));
	}

	@Test
	public void winDiagonallyReturnsTrueForTopLeftToBottomRightWin() {
		for (int space = 0; space < 3; space++) {
			move.row = space;
			move.col = space;
			board.setSpace(space, space, "X");
		}

		assertEquals(true, rules.isWinnerDiagonally("X"));
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

		assertTrue(rules.isWinnerDiagonally("X"));
	}

	@Test
	public void isDrawReturnsTrueWhenAllSpacesTakenAndNoWinner() {
		board = generateDrawState();
		rules.setBoard(board);
		assertTrue(rules.isDraw());
	}

	@Test
	public void isGameOverReturnsTrueWhenThereIsAWinnerOrDraw() {
		board = generateDrawState();
		rules.setBoard(board);
		assertTrue(rules.isGameOver());
	}

	@Test
	public void isGameOverReturnsFalseWhenNoWinnerAndNoDraw() {
		assertEquals(false, rules.isGameOver());
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
