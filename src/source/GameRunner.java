package source;

import java.util.Scanner;

import source.TTT.Game;
import source.TTT.GameRules;
import source.TTT.Player;
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
			currentPlayer.makeMove(game);
			helper.getWriter().printBoard(game.getBoard());
			game.nextTurn();
		}
		helper.getWriter().printGameState(game);
	}
}
