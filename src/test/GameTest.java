package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Game;
import source.Player;

public class GameTest {
	Player player1, player2;
	Board board;
	Game game;
	Game.Move move;

	@Before
	public void before(){
		player1 = new Player("X", "human");
		player2 = new Player("O", "computer");
		board = new Board();
		game = new Game(board, player1, player2);
		move = game.new Move(0,0);
	}
	
	@Test
	public void gameHasABoard(){
		assertNotNull(game.getBoard());
	}
	
	@Test
	public void gameBoardUpdatesWhenTurnIsTaken(){
		move = game.new Move(0,0);
		
		game.takeTurn(player1, move);
		
		assertEquals("X", game.getBoard().state[0][0]);
	}
}
