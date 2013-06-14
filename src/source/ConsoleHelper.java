package source;

import java.util.ArrayList;

public class ConsoleHelper {

	public String greetUser() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to Tic Tac Toe!\n");
		sb.append("What configuration of players would you like to play with?\n");
		sb.append("H: Human | C: Computer\n");
		sb.append("HvH, CvC, HvC, or CvH?  (case does not matter)");
		return sb.toString();
	}

	public boolean isValidPlayerConfig(String playerConfig) {
		boolean valid = false;
		if (playerConfig.equals("hvh") || playerConfig.equals("hvc")
				|| playerConfig.equals("cvh") || playerConfig.equals("cvc"))
			valid = true;
		return valid;
	}

	public ArrayList<Player> createPlayers(String playerConfig) {
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
