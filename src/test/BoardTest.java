package test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
				assertEquals ("", board.state[row][col]);
				assertNotNull(board.state[row][col]);
			}
		}
	}

	@Test
	public void printsBoardNicely() {
		String boardView = board.print();
		String expected = "[][][]\n[][][]\n[][][]";
		assert (boardView.equals(expected));
	}

	@Test
	public void winHorizontallyReturnsTrueForWinnerByRow() {
		for (int col = 0; col < 3; col++) {
			move.row = 0;
			move.col = col;
			board.state[move.row][move.col] = "X";
		}

		assertEquals(true, board.isWinnerHorizontally("X"));
	}

	@Test
	public void winVerticallyReturnsTrueForWinnerByColumn() {
		for (int row = 0; row < 3; row++) {
			move.row = row;
			move.col = 0;
			board.state[move.row][move.col] = "X";
		}

		assertEquals(true, board.isWinnerVertically("X"));
	}

	@Test
	public void winDiagonallyReturnsTrueForTopLeftToBottomRightWin() {
		for (int space = 0; space < 3; space++) {
			move.row = space;
			move.col = space;
			board.state[move.row][move.col] = "X";
		}

		assertEquals(true, board.isWinnerDiagonally("X"));
	}
	
	@Test
	public void getAvailableMovesReturnsAllMovesForEmptyBoard(){
		ArrayList<Move> moves = board.getAvailableMoves();
		assertEquals(9, moves.size());
	}
	
	@Test
	public void getAvailableMovesLeavesOutMarkedSpaces(){
		move.row = 0;
		move.col = 0;
		game.takeTurn(player1, move);
		
		ArrayList<Move> moves = board.getAvailableMoves();
		
		assertEquals(8, moves.size());
	}
}
