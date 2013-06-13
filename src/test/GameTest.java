package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
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
}
