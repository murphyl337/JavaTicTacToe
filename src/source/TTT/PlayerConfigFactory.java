package source.TTT;

import java.util.ArrayList;

import source.handles.HumanStrategyHandle;
import source.handles.MinimaxStrategyHandle;
import source.handles.RandomMoveStrategyHandle;


public class PlayerConfigFactory {
	public ArrayList<Player> createConfiguration(String playerConfig) {
		if (playerConfig.equalsIgnoreCase("hvh"))
			return createHVHConfig();
		if (playerConfig.equalsIgnoreCase("hvc"))
			return createHVCConfig();
		if (playerConfig.equalsIgnoreCase("cvh"))
			return createCVHConfig();
		if (playerConfig.equalsIgnoreCase("cvc"))
			return createCVCConfig();
		return null;
	}
	
	public ArrayList<Player> createHVHConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		HumanStrategyHandle humanHandle = new HumanStrategyHandle();
		Player player1 = new Player("X", humanHandle);
		Player player2 = new Player("O", humanHandle);
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createHVCConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		HumanStrategyHandle humanHandle = new HumanStrategyHandle();
		MinimaxStrategyHandle minimaxHandle = new MinimaxStrategyHandle();
		Player player1 = new Player("X", humanHandle);
		Player player2 = new Player("O", minimaxHandle);
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createCVHConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		HumanStrategyHandle humanHandle = new HumanStrategyHandle();
		MinimaxStrategyHandle minimaxHandle = new MinimaxStrategyHandle();
		Player player1 = new Player("X", minimaxHandle);
		Player player2 = new Player("O", humanHandle);
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createCVCConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		RandomMoveStrategyHandle randomMoveHandle = new RandomMoveStrategyHandle();
		Player player1 = new Player("X", randomMoveHandle);
		Player player2 = new Player("O", randomMoveHandle);
		players.add(player1);
		players.add(player2);
		return players;
	}
}
