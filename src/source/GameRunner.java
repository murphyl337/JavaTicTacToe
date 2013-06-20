package source;

import java.util.Scanner;

import source.TTT.Game;
import source.TTT.GameRules;
import source.TTT.Player;
import source.TTT.Position;
import source.console.ConsoleHelper;

public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConsoleHelper consoleHelper = new ConsoleHelper(scanner);
		Game game = consoleHelper.setUpGame();
		playGame(game, consoleHelper);
	}

	public static void playGame(Game game, ConsoleHelper helper) {
		helper.getWriter().printTemplateBoard();
		while (!GameRules.isGameOver(game.getBoard())) {
			Player currentPlayer = game.getCurrentPlayer();
			if (game.getCurrentPlayer().isHuman()) {
				Position move = helper.getReader().getMoveInput();
				if (!GameRules.isValidMove(move, game.getBoard())) {
					System.out.println("Move taken");
					continue;
				}
				game.takeTurn(currentPlayer, move);
				helper.getWriter().printBoard(game.getBoard());
			} else {
				makeComputerMove(game, helper, currentPlayer);
			}
			game.nextTurn();
		}
		helper.getWriter().printGameState(game);
	}

	private static void makeComputerMove(Game game, ConsoleHelper helper,
			Player currentPlayer) {
		game.takeTurn(currentPlayer, game.getArtificialIntelligence()
				.getBestMove(game.getBoard(), currentPlayer));
		helper.getWriter().printBoard(game.getBoard());
	}
}
