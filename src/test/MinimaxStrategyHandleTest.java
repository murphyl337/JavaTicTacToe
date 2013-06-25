package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Board;
import source.TTT.Game;
import source.TTT.Player;
import source.TTT.Position;
import source.handles.MinimaxStrategyHandle;

public class MinimaxStrategyHandleTest {
	Game game;
	Board board;
	Player player1, player2;
	MinimaxStrategyHandle minimaxHandle;
	
	@Before
	public void beforeAll(){
		board = new Board();
		minimaxHandle = new MinimaxStrategyHandle();
		player1 = new Player("X", minimaxHandle);
		player2 = new Player("O", minimaxHandle);
		game = new Game(board, player1, player2);
		minimaxHandle.setGame(game);
		minimaxHandle.setPlayer(player2);
	}

	@Test
	public void getMoveReturnsCenterSpaceWhenCornerIsTaken() {
		Position move = new Position(0,0);
		game.updateBoard("X", move);
		assertEquals(1, minimaxHandle.getMove().row);
		assertEquals(1, minimaxHandle.getMove().col);
	}
}
