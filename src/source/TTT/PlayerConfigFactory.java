package source.TTT;

import java.util.ArrayList;

import source.handles.HumanStrategyHandle;
import source.handles.MinimaxStrategyHandle;
import source.handles.RandomMoveStrategyHandle;
import source.handles.StrategyHandle;

public class PlayerConfigFactory {

	private StrategyHandle createStrategyHandle(String difficulty) {
		if (difficulty.equalsIgnoreCase("e"))
			return new RandomMoveStrategyHandle();
		else
			return new MinimaxStrategyHandle();
	}

	public ArrayList<Player> createConfiguration(String playerConfig,
			String difficulty) {
		StrategyHandle strategy = createStrategyHandle(difficulty);
		if (playerConfig.equalsIgnoreCase("hvh"))
			return createHVHConfig();
		if (playerConfig.equalsIgnoreCase("hvc"))
			return createHVCConfig(strategy);
		if (playerConfig.equalsIgnoreCase("cvh"))
			return createCVHConfig(strategy);
		if (playerConfig.equalsIgnoreCase("cvc"))
			return createCVCConfig(strategy);
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

	public ArrayList<Player> createHVCConfig(StrategyHandle strategy) {
		ArrayList<Player> players = new ArrayList<Player>();
		HumanStrategyHandle humanHandle = new HumanStrategyHandle();
		Player player1 = new Player("X", humanHandle);
		Player player2 = new Player("O", strategy);
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createCVHConfig(StrategyHandle strategy) {
		ArrayList<Player> players = new ArrayList<Player>();
		HumanStrategyHandle humanHandle = new HumanStrategyHandle();
		Player player1 = new Player("X", strategy);
		Player player2 = new Player("O", humanHandle);
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createCVCConfig(StrategyHandle strategy) {
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player("X", strategy);
		Player player2 = new Player("O", strategy);
		players.add(player1);
		players.add(player2);
		return players;
	}
}
