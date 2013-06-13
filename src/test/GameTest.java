package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import source.Board;
import source.Game;
import source.Move;
import source.Player;

public class GameTest {
	Player player1, player2;
	Board board;
	Game game;
	Move move;

	@Before
	public void before(){
		player1 = new Player("X", "human");
		player2 = new Player("O", "computer");
		board = new Board();
		game = new Game(board, player1, player2);
		move = new Move(0,0);
	}
	
	@Test
	public void gameHasABoard(){
		assertNotNull(game.getBoard());
	}
	
	@Test
	public void gameBoardUpdatesWhenTurnIsTaken(){
		game.takeTurn(player1, move);
		
		assertEquals("X", game.getBoard().state[0][0]);
	}
	
	@Test
	public void defaultBestScoreIsIntMaxForP1IntMinForP2(){
		int bestScore = game.getDefaultBestScore(player1);
		assertEquals(Integer.MIN_VALUE, bestScore);
		
		bestScore = game.getDefaultBestScore(player2);
		assertEquals(Integer.MAX_VALUE, bestScore);
	}
	
	@Test
	public void isBestScoreForPlayer1IsTrueForScoreGreaterThanBestScore(){
		int score = 1;
		int bestScore = game.getDefaultBestScore(player1);
		
		assertTrue(game.isBestScore(score, bestScore, player1));
	}
	
	@Test
	public void isBestScoreForPlayer2IsTrueForScoreLessThanBestScore(){
		int score = -1;
		int bestScore = game.getDefaultBestScore(player2);
		
		assertTrue(game.isBestScore(score, bestScore, player2));
	} 
	
	@Test
	public void getBestMoveReturnsCenterSpaceWhenCornerIsTaken(){
		game.takeTurn(player1, move);
		
		move = game.getBestMove(game.getBoard(), player2);

		assertEquals(1, move.row);
		assertEquals(1, move.col);
	}
	
	@Test
	public void getBestMoveIsWinningMove(){
		board.update("X", move);
		move = new Move(0,1);
		board.update("X", move);
		move = new Move(1,0);
		board.update("X", move);
		move = new Move(1,1);
		board.update("O", move);
		move = new Move(2,0);
		board.update("O", move);
		
		move = game.getBestMove(board, player2);
		assertEquals(0, move.row);
		assertEquals(2, move.col);
	}
}
