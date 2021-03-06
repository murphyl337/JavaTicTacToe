package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Board;
import source.TTT.Game;
import source.TTT.Position;
import source.handles.HumanStrategyHandle;

public class BoardTest {
	HumanStrategyHandle humanHandle;
	
	Board board;
	Position move;
	Game game;

	@Before
	public void beforeAll() {
		board = new Board();
		game = new Game(board, null, null);
		move = new Position(0, 0);
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
		clone.setSpace(move, "X");

		assertEquals("", board.getSpace(0, 0));
		assertEquals("X", clone.getSpace(0, 0));
	}

	@Test
	public void getAvailablePositionsReturnsAllMovesForEmptyBoard() {
		ArrayList<Position> moves = board.getAvailablePositions();
		assertEquals(9, moves.size());
	}

	@Test
	public void getAvailablePositionsLeavesOutMarkedSpaces() {
		move.row = 0;
		move.col = 0;
		board.setSpace(0, 0, "X");

		ArrayList<Position> moves = board.getAvailablePositions();

		assertEquals(8, moves.size());
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
