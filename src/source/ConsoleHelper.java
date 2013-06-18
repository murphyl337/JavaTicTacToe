package source;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHelper {
	PlayerConfigFactory configFactory;

	public ConsoleHelper() {
		configFactory = new PlayerConfigFactory();
	}

	public void greetUser() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to Tic Tac Toe!\n");
		sb.append("What configuration of players would you like to play with?\n");
		sb.append("H: Human | C: Computer\n");
		sb.append("HvH, CvC, HvC, or CvH?  (case does not matter)");
		System.out.println(sb.toString());
	}
	
	public void printTemplateBoard(){
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + row + " , " + col + "]");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public boolean isValidPlayerConfig(String playerConfig) {
		boolean valid = false;
		if (playerConfig.equalsIgnoreCase("hvh")
				|| playerConfig.equalsIgnoreCase("hvc")
				|| playerConfig.equalsIgnoreCase("cvh")
				|| playerConfig.equalsIgnoreCase("cvc"))
			valid = true;
		return valid;
	}

	public ArrayList<Player> createPlayers(String playerConfig) {
		ArrayList<Player> players = configFactory
				.createConfiguration(playerConfig);
		return players;
	}

	public boolean isValidMoveInput(String moveString) {
		return moveString.matches("[0-2],[0-2]");
	}

	public Position getMoveInput() {
		System.out.println("What move would you like to take? (row,col)");
		Scanner scanner = new Scanner(System.in);
		String moveInput = "";
		boolean validMoveInput = false;

		while (!validMoveInput) {
			String move = scanner.nextLine();
			if (!isValidMoveInput(move)) {
				System.out.println("Incorrect input. (e.g: 0,0 - 2,2)");
				continue;
			}
			validMoveInput = true;
			moveInput = move;
		}

		String[] moveArray = moveInput.split(",");
		Position move = new Position(moveArray[0], moveArray[1]);
		return move;
	}

	public Game setUpGame(Scanner scanner) {
		greetUser();
		scanner = new Scanner(System.in);
		String playerConfig = "";
		boolean validPlayerConfig = false;

		while (!validPlayerConfig) {
			String config = scanner.nextLine();
			if (!isValidPlayerConfig(config)) {
				System.out
						.println("Incorrect configuration. (hvh, hvc, cvh, cvc)");
				continue;
			}
			validPlayerConfig = true;
			playerConfig = config;
		}

		ArrayList<Player> players = createPlayers(playerConfig);
		Board board = new Board();
		GameRules rules = new GameRules(board);
		Game game = new Game(rules, board, players.get(0), players.get(1));
		return game;
	}
}
