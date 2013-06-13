package test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import source.Player;

public class PlayerTest {
	Player player1;

	@Before
	public void before(){
		player1 = new Player("X", "computer");
	}
	
	@Test
	public void playerHasAMarker() {
		assert(player1.getMarker().equals("X"));
	}
	
	@Test
	public void playerHasAType(){
		assert(player1.getType().equals("computer"));
	}

}
