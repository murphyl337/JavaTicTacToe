package source;

import java.util.Scanner;


public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConsoleHelper consoleHelper = new ConsoleHelper();
		Game game = consoleHelper.setUpGame(scanner);
		game.playGame();
	}
}
