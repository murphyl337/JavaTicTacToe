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
		board = new Board(player1, player2);
		game = new Game(board);
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
	
	@Test
	public void winHorizontallyReturnsTrueForWinnerByRow(){
		for(int col=0; col<3; col++){
			move.row = 0;
			move.col = col;
			game.takeTurn(player1, move);
		}
		
		assertEquals(true, game.isWinnerHorizontally(player1.getMarker()));
	}
	

}
