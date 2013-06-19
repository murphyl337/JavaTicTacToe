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
		game.playGame();
	}
}
