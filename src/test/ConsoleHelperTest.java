package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.ConsoleHelper;
import source.Player;

public class ConsoleHelperTest {
	ConsoleHelper consoleHelper;
	
	@Before
	public void before(){
		consoleHelper = new ConsoleHelper();
	}
	
	@Test
	public void canCreateHVHConfig(){
		ArrayList<Player> players = consoleHelper.createHVHConfig();
		assertEquals(2, players.size());
		assertEquals("human", players.get(0).getType());
		assertEquals("X", players.get(0).getMarker());
		assertEquals("human", players.get(1).getType());
	}
	
	@Test
	public void canCreateHVConfig(){
		ArrayList<Player> players = consoleHelper.createHVCConfig();
		assertEquals(2, players.size());
		assertEquals("human", players.get(0).getType());
		assertEquals("computer", players.get(1).getType());
	}
	
	@Test
	public void canCreateCVHConfig(){
		ArrayList<Player> players = consoleHelper.createCVHConfig();
		assertEquals(2, players.size());
		assertEquals("computer", players.get(0).getType());
		assertEquals("human", players.get(1).getType());
	}
	
	@Test
	public void canCreateCVCConfig(){
		ArrayList<Player> players = consoleHelper.createCVCConfig();
		assertEquals(2, players.size());
		assertEquals("computer", players.get(0).getType());
		assertEquals("computer", players.get(1).getType());
	}
	
	@Test
	public void validatesPlayerConfigInput(){
		ArrayList<Player> players = null;
		consoleHelper.isValidPlayerConfig("pvp");
	}
}
