package source;

import java.util.ArrayList;

public class ArtificialIntelligence {
	private Game game;

	public ArtificialIntelligence(Game game) {
		this.game = game;
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

	public Position getBestMove(Board board, Player player) {
		Position bestMove = null;

		Player otherPlayer = game.getOtherPlayer(player);
		ArrayList<Position> availablePositions = board.getAvailablePositions();
		int bestScore = getDefaultBestScore(player);

		for (int space = 0; space < availablePositions.size(); space++) {
			Board boardClone = board.copy();
			GameRules rulesCopy = new GameRules(boardClone);
			boardClone.setSpace(availablePositions.get(space), player.getMarker());
			int currentScore = minimax(rulesCopy, boardClone, otherPlayer);
			boolean isBestScore = isBestScore(currentScore, bestScore, player);
			if (isBestScore) {
				bestScore = currentScore;
				bestMove = availablePositions.get(space);
			}
		}
		return bestMove;
	}

	public int minimax(GameRules rules, Board board, Player player) {
		if (rules.isWinner(getGame().getPlayer1().getMarker()))
			return 1;
		if (rules.isWinner(getGame().getPlayer2().getMarker()))
			return -1;
		if (rules.isDraw())
			return 0;

		Player otherPlayer = game.getOtherPlayer(player);
		ArrayList<Position> availablePositions = board.getAvailablePositions();
		int bestScore = getDefaultBestScore(player);

		for (int space = 0; space < availablePositions.size(); space++) {
			Board boardClone = board.copy();
			GameRules rulesCopy = new GameRules(boardClone);
			boardClone.setSpace(availablePositions.get(space), player.getMarker());
			int score = minimax(rulesCopy, boardClone, otherPlayer);
			boolean isBestScore = isBestScore(score, bestScore, player);
			if (isBestScore)
				bestScore = score;
		}
		return bestScore;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
