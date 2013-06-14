package source;


public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleHelper consoleHelper = new ConsoleHelper();
		Game game = consoleHelper.setUpGame();
		consoleHelper.playGame(game);
	}
}
