package source.console;

import java.util.ArrayList;
import java.util.Scanner;

import source.TTT.Board;
import source.TTT.Game;
import source.TTT.Player;
import source.TTT.PlayerConfigFactory;

public class ConsoleHelper {
	private PlayerConfigFactory configFactory;
	private Scanner scanner;
	private ConsoleValidator validator;
	private ConsoleWriter writer;
	private ConsoleReader reader;

	public ConsoleHelper(Scanner scanner) {
		this.scanner = scanner;
		this.configFactory = new PlayerConfigFactory();
		this.validator = new ConsoleValidator();
		this.writer = new ConsoleWriter();
		this.reader = new ConsoleReader(scanner);
	}

	public Game setUpGame() {
		getWriter().printGreeting();
		String playerConfig = getReader().getPlayerConfig();
		ArrayList<Player> players = configFactory.createConfiguration(playerConfig);
		Board board = new Board();
		Game game = new Game(board, players.get(0), players.get(1));
		return game;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public ConsoleValidator getValidator() {
		return validator;
	}

	public void setValidator(ConsoleValidator validator) {
		this.validator = validator;
	}

	public ConsoleWriter getWriter() {
		return writer;
	}

	public void setWriter(ConsoleWriter writer) {
		this.writer = writer;
	}

	public ConsoleReader getReader() {
		return reader;
	}

	public void setReader(ConsoleReader reader) {
		this.reader = reader;
	}
}
