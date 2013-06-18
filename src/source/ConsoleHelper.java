package source;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHelper {
	PlayerConfigFactory configFactory;
	
	public ConsoleHelper(){
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
		ArrayList<Player> players = configFactory.createConfiguration(playerConfig);
		return players;
	}


	public boolean isValidMoveInput(String moveString) {
		return moveString.matches("[0-2],[0-2]");
	}
	
	public Move getMoveInput() {
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
		Move move = new Move(moveArray[0], moveArray[1]);
		return move;
	}

	public Game setUpGame() {
		greetUser();
		Scanner scanner = new Scanner(System.in);
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
		Game game = new Game(board, players.get(0), players.get(1));
		return game;
	}

	public void playGame(Game game) {
		System.out.println("These are the moves you can make: ");
		game.getBoard().printTemplateBoard();
		while (game.active) {
			if (game.getCurrentPlayer().isHuman()) {
				Move move = getMoveInput();
				if (!game.getRules().isValidMove(move)) {
					System.out.println("Move taken");
					continue;
				}
				game.takeTurn(game.getCurrentPlayer(), move);
				System.out.println(game.getBoard().toString());

			}
			if (game.getCurrentPlayer().isComputer()) {
				makeComputerMove(game);
			}
			if (game.getBoard().isGameOver())
				game.active = false;

			game.nextTurn();
		}
		game.printState();
	}

	private void makeComputerMove(Game game) {
		Player currentPlayer = game.getCurrentPlayer();
		Board board = game.getBoard();
		game.takeTurn(currentPlayer, game.getBestMove(board, currentPlayer));
		System.out.println(board.toString());
	}
}
