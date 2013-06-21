package source.handles;

import java.util.ArrayList;

import source.TTT.Board;
import source.TTT.Game;
import source.TTT.GameRules;
import source.TTT.Player;
import source.TTT.Position;

public class MinimaxStrategyHandle implements StrategyHandle {
	private Player player = null;
	private Game game = null;

	@Override
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Position getMove() {
		Position bestMove = null;

		Player otherPlayer = game.getOtherPlayer(player);
		ArrayList<Position> availablePositions = game.getBoard().getAvailablePositions();
		int bestScore = getDefaultBestScore(player);

		for (int space = 0; space < availablePositions.size(); space++) {
			Board boardClone = game.getBoard().copy();
			boardClone.setSpace(availablePositions.get(space), player.getMarker());
			int currentScore = minimax(boardClone, otherPlayer);
			boolean isBestScore = isBestScore(currentScore, bestScore, player);
			if (isBestScore) {
				bestScore = currentScore;
				bestMove = availablePositions.get(space);
			}
		}
		return bestMove;
	}
	
	public int minimax(Board board, Player player){
		if (GameRules.isWinner(game.getPlayer1().getMarker(), board))
			return 1;
		if (GameRules.isWinner(game.getPlayer2().getMarker(), board))
			return -1;
		if (GameRules.isDraw(board))
			return 0;

		Player otherPlayer = game.getOtherPlayer(player);
		ArrayList<Position> availablePositions = board.getAvailablePositions();
		int bestScore = getDefaultBestScore(player);

		for (int space = 0; space < availablePositions.size(); space++) {
			Board boardClone = board.copy();
			boardClone.setSpace(availablePositions.get(space), player.getMarker());
			int score = minimax(boardClone, otherPlayer);
			boolean isBestScore = isBestScore(score, bestScore, player);
			if (isBestScore)
				bestScore = score;
		}
		return bestScore;
	}

	public int getDefaultBestScore(Player player) {
		if (player == game.getPlayer1())
			return Integer.MIN_VALUE;
		return Integer.MAX_VALUE;
	}

	public boolean isBestScore(int score, int bestScore, Player player) {
		boolean isBestScore = false;
		if (player == game.getPlayer1()) {
			if (score > bestScore)
				isBestScore = true;
		} else if (player == game.getPlayer2()) {
			if (score < bestScore)
				isBestScore = true;
		}
		return isBestScore;
	}

}
