package source.console;

public class ConsoleValidator {
	
	public boolean isValidPlayerConfig(String playerConfig) {
		boolean valid = false;
		if (playerConfig.equalsIgnoreCase("hvh")
				|| playerConfig.equalsIgnoreCase("hvc")
				|| playerConfig.equalsIgnoreCase("cvh")
				|| playerConfig.equalsIgnoreCase("cvc"))
			valid = true;
		return valid;
	}
	
	public boolean isValidMoveInput(String moveString) {
		return moveString.matches("[0-2],[0-2]");
	}
	
}
