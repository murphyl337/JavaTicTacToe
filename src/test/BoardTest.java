package test;

import static org.junit.Assert.*;
import org.hamcrest.Matcher;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import source.Board;
import source.Player;

public class BoardTest {
	Player player1, player2;
	Board board;
	
	@Before
	public void beforeAll(){
		player1 = new Player();
		player2 = new Player();
		board 	= new Board(player1, player2);
	}
	
	@Test
	public void boardIsEmptyWhenInstantiated() {
		for(int space=0; space<3; space++){
			assert(board.state[space].equals(""));
		}
	}
	
	@Test
	public void boardHasTwoPlayers(){
		assert(board.players.size() == 2);
	}

	
}
