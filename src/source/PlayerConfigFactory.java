package source;

import java.util.ArrayList;

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
		Player player1 = new Player("X", "human");
		Player player2 = new Player("O", "human");
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createHVCConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player("X", "human");
		Player player2 = new Player("O", "computer");
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createCVHConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player("X", "computer");
		Player player2 = new Player("O", "human");
		players.add(player1);
		players.add(player2);
		return players;
	}

	public ArrayList<Player> createCVCConfig() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player("X", "computer");
		Player player2 = new Player("O", "computer");
		players.add(player1);
		players.add(player2);
		return players;
	}
}
