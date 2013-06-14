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
	public void getOtherPlayerReturnsOppositeOfPassedInPlayer() {
		Player otherPlayer = game.getOtherPlayer(player1);

		assertEquals(player2, otherPlayer);

		otherPlayer = game.getOtherPlayer(player2);

		assertEquals(player1, otherPlayer);
	}
	
	@Test
	public void nextTurnChangesCurrentPlayer(){
		game.nextTurn();
		assertEquals(player2, game.getCurrentPlayer());
	}
}
