package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.TTT.Player;
import source.TTT.PlayerConfigFactory;
import source.handles.HumanStrategyHandle;
import source.handles.MinimaxStrategyHandle;

public class PlayerConfigFactoryTest {
	PlayerConfigFactory configFactory;

	@Before
	public void before(){
		configFactory = new PlayerConfigFactory();
	}
	
	@Test
	public void canCreateHVHConfig(){
		ArrayList<Player> players = configFactory.createHVHConfig();
		assertEquals(2, players.size());
		assertEquals(HumanStrategyHandle.class, players.get(0).getStrategyHandle().getClass());
		assertEquals("X", players.get(0).getMarker());
		assertEquals(HumanStrategyHandle.class, players.get(1).getStrategyHandle().getClass());
	}
	
	@Test
	public void canCreateHVConfig(){
		ArrayList<Player> players = configFactory.createHVCConfig();
		assertEquals(2, players.size());
		assertEquals(HumanStrategyHandle.class, players.get(0).getStrategyHandle().getClass());
		assertEquals(MinimaxStrategyHandle.class, players.get(1).getStrategyHandle().getClass());
	}
	
	@Test
	public void canCreateCVHConfig(){
		ArrayList<Player> players = configFactory.createCVHConfig();
		assertEquals(2, players.size());
		assertEquals(MinimaxStrategyHandle.class, players.get(0).getStrategyHandle().getClass());
		assertEquals(HumanStrategyHandle.class, players.get(1).getStrategyHandle().getClass());
	}
	
	@Test
	public void canCreateCVCConfig(){
		ArrayList<Player> players = configFactory.createCVCConfig();
		assertEquals(2, players.size());
		assertEquals(MinimaxStrategyHandle.class, players.get(0).getStrategyHandle().getClass());
		assertEquals(MinimaxStrategyHandle.class, players.get(1).getStrategyHandle().getClass());
	}

}
