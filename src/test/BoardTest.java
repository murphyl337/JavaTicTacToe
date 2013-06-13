package test;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Player;

public class BoardTest {
	Player player1, player2;
	Board board;
	
	@Before
	public void beforeAll(){
		player1 = new Player("X", "human");
		player2 = new Player("O", "computer");
		board 	= new Board(player1, player2);
	}
	
	@Test
	public void boardIsEmptyWhenInstantiated() {
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++){
				assert(board.state[row][col].equals(""));
				assert(!board.state[row][col].equals(null));
			}
		}
	}
	
	@Test
	public void boardHasTwoPlayers(){
		assert(board.players.size() == 2);
	}

	@Test
	public void printsBoardNicely(){
		String boardView = board.print();
		String expected = "[][][]\n[][][]\n[][][]";
		assert(boardView.equals(expected));
	}
}
