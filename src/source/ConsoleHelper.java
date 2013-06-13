package source;

import java.util.Scanner;

public class ConsoleHelper {

	public Player createPlayers() {
		return null;
	}

	public String determinePlayerType(String humanOrNot) {
		if(humanOrNot.equals("y"))
			return "human";
		return "computer";
	}

	public boolean isValidTypeInput(String typeInput) {
		boolean valid = false;
		if(typeInput.equals("y") || typeInput.equals("n")) valid = true;
		return valid;
	}

}
