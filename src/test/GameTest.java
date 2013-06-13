package test;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Player;

public class GameTest {
	Player player1, player2;
	Board board;

	@Before
	public void before(){
		player1 = new Player("X", "human");
		player2 = new Player("O", "computer");
		board = new Board(player1, player2);
	}
	
	@Test
	public void determinesWinnerByRow() {
		for(int col=0; col<3; col++)
			board.state[0][col] = player1.getMarker();
		
	}

}
