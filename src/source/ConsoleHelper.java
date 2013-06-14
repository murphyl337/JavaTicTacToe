package source;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHelper {

	public void greetUser() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to Tic Tac Toe!\n");
		sb.append("What configuration of players would you like to play with?\n");
		sb.append("H: Human | C: Computer\n");
		sb.append("HvH, CvC, HvC, or CvH?  (case does not matter)");
		System.out.println(sb.toString());
	}

	public boolean isValidPlayerConfig(String playerConfig) {
		boolean valid = false;
		if (playerConfig.equalsIgnoreCase("hvh") || playerConfig.equalsIgnoreCase("hvc")
				|| playerConfig.equalsIgnoreCase("cvh") || playerConfig.equalsIgnoreCase("cvc"))
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

	public boolean isValidMoveInput(String moveString) {
		return moveString.matches("[0-2],[0-2]"); 
	}
	
	public Game setUpGame(){
		greetUser();
		Scanner scanner = new Scanner(System.in);
		String playerConfig = "";
		boolean validPlayerConfig = false;
		
		while(!validPlayerConfig){
			String config = scanner.nextLine();
			if(!isValidPlayerConfig(config)){
				System.out.println("Incorrect configuration. (hvh, hvc, cvh, cvc)");
				continue;
			}
			validPlayerConfig = true;
			playerConfig = config;
		}
		
		ArrayList<Player> players = createPlayers(playerConfig);
		Board board = new Board();
		Game game = new Game(board, players.get(0), players.get(1));
		return game;
	}
}
