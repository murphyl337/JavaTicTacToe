package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.ConsoleHelper;
import source.Player;
import source.PlayerConfigFactory;

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
		assertEquals("human", players.get(0).getType());
		assertEquals("X", players.get(0).getMarker());
		assertEquals("human", players.get(1).getType());
	}
	
	@Test
	public void canCreateHVConfig(){
		ArrayList<Player> players = configFactory.createHVCConfig();
		assertEquals(2, players.size());
		assertEquals("human", players.get(0).getType());
		assertEquals("computer", players.get(1).getType());
	}
	
	@Test
	public void canCreateCVHConfig(){
		ArrayList<Player> players = configFactory.createCVHConfig();
		assertEquals(2, players.size());
		assertEquals("computer", players.get(0).getType());
		assertEquals("human", players.get(1).getType());
	}
	
	@Test
	public void canCreateCVCConfig(){
		ArrayList<Player> players = configFactory.createCVCConfig();
		assertEquals(2, players.size());
		assertEquals("computer", players.get(0).getType());
		assertEquals("computer", players.get(1).getType());
	}

}
