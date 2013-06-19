package source;

import java.util.Scanner;

public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConsoleHelper consoleHelper = new ConsoleHelper(scanner);
		Game game = consoleHelper.setUpGame();
		playGame(game);
	}

	public static void playGame(Game game) {
		Scanner scanner = new Scanner(System.in);
		ConsoleHelper helper = new ConsoleHelper(scanner);
		helper.printTemplateBoard();
		while (!game.getRules().isGameOver()) {
			Player currentPlayer = game.getCurrentPlayer();
			if (game.getCurrentPlayer().isHuman()) {
				Position move = helper.getMoveInput();
				if (!game.getRules().isValidMove(move)) {
					System.out.println("Move taken");
					continue;
				}
				game.takeTurn(currentPlayer, move);
				helper.printBoard(game.getBoard());
			} else {
				game.takeTurn(currentPlayer, game.getArtificialIntelligence()
						.getBestMove(game.getBoard(), currentPlayer));
				helper.printBoard(game.getBoard());
			}
			game.nextTurn();
		}
		helper.printGameState(game);
	}
}
