package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import source.Board;
import source.Game;
import source.Player;

public class BoardTest {
	Player player1, player2;
	Board board;
	Game.Move move;
	Game game;
	
	@Before
	public void beforeAll(){
		player1 = new Player("X", "human");
		player2 = new Player("O", "human");
		board 	= new Board();
		game = new Game(board, player1, player2);
		move	= game.new Move(0,0);
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
	public void printsBoardNicely(){
		String boardView = board.print();
		String expected = "[][][]\n[][][]\n[][][]";
		assert(boardView.equals(expected));
	}
	
	@Test
	public void winHorizontallyReturnsTrueForWinnerByRow(){
		for(int col=0; col<3; col++){
			move.row = 0;
			move.col = col;
			board.state[move.row][move.col] = "X";
		}
		
		assertEquals(true, board.isWinnerHorizontally("X"));
	}
	
	@Test
	public void winVerticallyReturnsTrueForWinnerByColumn(){
		for(int row=0; row<3; row++){
			move.row = row;
			move.col = 0;
			board.state[move.row][move.col] = "X";
		}
		
		assertEquals(true, board.isWinnerVertically("X"));
	}
	
	@Test
	public void winDiagonallyReturnsTrueForTopLeftToBottomRightWin(){
		for(int space=0; space<3; space++){
			move.row = space;
			move.col = space;
			board.state[move.row][move.col] = "X";
		}
		
		assertEquals(true, board.isWinnerDiagonally("X"));
	}
}
