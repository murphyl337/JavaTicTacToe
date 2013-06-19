package source.console;

import java.util.Scanner;

import source.TTT.Position;

public class ConsoleReader {
	private Scanner scanner;
	private ConsoleValidator validator;
	
	public ConsoleReader(Scanner scanner){
		this.scanner = scanner;
		this.validator = new ConsoleValidator();
	}
	
	public Position getMoveInput() {
		System.out.println("What move would you like to take? (row,col)");
		boolean validMoveInput = false;
		Position move = null;
		while (!validMoveInput) {
			String moveString = getScanner().nextLine();
			if (!validator.isValidMoveInput(moveString)) {
				System.out.println("Incorrect input. (e.g: 0,0 - 2,2)");
				continue;
			}
			validMoveInput = true;
			move = new Position(moveString);
		}
		return move;
	}
	
	public String getPlayerConfig(){
		boolean validPlayerConfig = false;
		String config = "";
		while (!validPlayerConfig) {
			config = getScanner().nextLine();
			if (!validator.isValidPlayerConfig(config)) {
				System.out
						.println("Incorrect configuration. (hvh, hvc, cvh, cvc)");
				continue;
			}
			validPlayerConfig = true;
		}
		return config;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}