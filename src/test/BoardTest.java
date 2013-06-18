package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Game;
import source.GameRules;
import source.Move;
import source.Player;

public class BoardTest {
	Player player1, player2;
	Board board;
	Move move;
	Game game;
	GameRules rules;

	@Before
	public void beforeAll() {
		player1 = new Player("X", "human");
		player2 = new Player("O", "human");
		board = new Board();
		rules = new GameRules(board);
		game = new Game(rules, board, player1, player2);
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
