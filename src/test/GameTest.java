package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Board;
import source.TTT.Game;
import source.TTT.Player;
import source.TTT.Position;

public class GameTest {
	Player player1, player2;
	Board board;
	Game game;
	Position move;

	@Before
	public void before(){
		player1 = new Player("X", null);
		player2 = new Player("O", null);
		board = new Board();
		game = new Game(board, player1, player2);
		move = new Position(0,0);
	}
	
	@Test
	public void gameHasABoard(){
		assertNotNull(game.getBoard());
	}
	
	@Test
	public void gameBoardUpdatesWhenTurnIsTaken(){
		game.updateBoard("X", move);
		
		assertEquals("X", game.getBoard().getSpace(0, 0));
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
