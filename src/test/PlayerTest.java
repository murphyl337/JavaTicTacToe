package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Player;
import source.handles.HumanStrategyHandle;
import source.handles.MinimaxStrategyHandle;

public class PlayerTest {
	Player player1, player2;
	HumanStrategyHandle humanHandle;
	MinimaxStrategyHandle minimaxHandle;

	@Before
	public void before(){
		humanHandle = new HumanStrategyHandle();
		minimaxHandle = new MinimaxStrategyHandle();
		
		player1 = new Player("X", minimaxHandle);
		player2 = new Player("O", humanHandle);
	}
	
	@Test
	public void hasAMarker(){
		assertEquals("X", player1.getMarker());
	}
	
	@Test
	public void hasAHandle(){
		assertNotNull(player1.getStrategyHandle());
	}
	
	
}
