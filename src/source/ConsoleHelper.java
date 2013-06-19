package source;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHelper {
	private PlayerConfigFactory configFactory;
	private Scanner scanner;

	public ConsoleHelper(Scanner scanner) {
		configFactory = new PlayerConfigFactory();
		this.scanner = scanner;
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
		System.out.println("These are the moves you can make: ");
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + row + "," + col + "]");
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

	public Position getMoveInput(GameRules rules) {
		System.out.println("What move would you like to take? (row,col)");
		boolean validMoveInput = false;
		Position move = null;
		while (!validMoveInput) {
			String moveString = getScanner().nextLine();
			if (!isValidMoveInput(moveString)) {
				System.out.println("Incorrect input. (e.g: 0,0 - 2,2)");
				continue;
			}
			move = new Position(moveString);
			if(!rules.isValidMove(move)){
				System.out.println("Move taken, please make another move");
				continue;
			}
			validMoveInput = true;
		}
		return move;
	}
	
	public String getPlayerConfig(){
		boolean validPlayerConfig = false;
		String config = "";
		while (!validPlayerConfig) {
			config = getScanner().nextLine();
			if (!isValidPlayerConfig(config)) {
				System.out
						.println("Incorrect configuration. (hvh, hvc, cvh, cvc)");
				continue;
			}
			validPlayerConfig = true;
		}
		return config;
	}

	public Game setUpGame() {
		greetUser();
		ArrayList<Player> players = createPlayers(getPlayerConfig());
		Board board = new Board();
		GameRules rules = new GameRules(board);
		Game game = new Game(rules, board, players.get(0), players.get(1));
		return game;
	}
	
	public void printGameState(Game game){
		if(game.getRules().isWinner("X"))
			System.out.println("X IS WINNER!");
		else if(game.getRules().isWinner("O"))
			System.out.println("O IS WINNER!");
		else if(game.getRules().isDraw())
			System.out.println("IT'S A DRAW!");
	}
	
	public void printBoard(Board board){
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + board.getSpace(row,col) + "]");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}
