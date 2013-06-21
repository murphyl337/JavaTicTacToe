package source.handles;

import java.util.Scanner;

import source.TTT.Game;
import source.TTT.GameRules;
import source.TTT.Player;
import source.TTT.Position;
import source.console.ConsoleReader;

public class HumanStrategyHandle implements StrategyHandle {
	private Player player = null;
	private Game game = null;

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public Position getMove() {
		Scanner scanner = new Scanner(System.in);
		ConsoleReader reader = new ConsoleReader(scanner);
		Position move = null;
		boolean validMove = false;
		while (!validMove) {
			move = reader.getMoveInput();
			if (!GameRules.isValidMove(move, game.getBoard())) {
				System.out.println("Move is taken");
				continue;
			}
			validMove = true;
		}
		return move;
	}

}
