package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Player;

public class PlayerTest {
	Player player1, player2;

	@Before
	public void before(){
		player1 = new Player("X", "computer");
		player2 = new Player("O", "human");
	}
	
	@Test
	public void playerHasAMarker() {
		assert(player1.getMarker().equals("X"));
	}
	
	@Test
	public void playerHasAType(){
		assert(player1.getType().equals("computer"));
	}

	@Test
	public void isHumanReturnsTrueForHumanPlayers(){
		assertFalse(player1.isHuman());
		assertTrue(player2.isHuman());
	}
	
	@Test
	public void isComputerReturnsTrueForComputerPlayers(){
		assertTrue(player1.isComputer());
		assertFalse(player2.isComputer());
	}
}
