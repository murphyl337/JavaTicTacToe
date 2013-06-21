package source.handles;

import java.util.Random;

import source.TTT.Game;
import source.TTT.GameRules;
import source.TTT.Player;
import source.TTT.Position;

public class RandomMoveStrategyHandle implements StrategyHandle {
	private Player player = null;
	private Game game = null;

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Position getMove() {
		boolean validMove = false;
		Position move = null;
		while (!validMove) {
			int row = getRandom(0, 3);
			int col = getRandom(0, 3);
			move = new Position(row, col);
			if (GameRules.isValidMove(move, game.getBoard())) {
				validMove = true;
			}
		}
		return move;
	}

	public static int getRandom(int from, int to) {
		if (from < to)
			return from + new Random().nextInt(Math.abs(to - from));
		return from - new Random().nextInt(Math.abs(to - from));
	}

}
