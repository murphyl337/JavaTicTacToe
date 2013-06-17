package source;

import java.util.ArrayList;

public class AI {
	public Game game;
	
	public AI(Game game){
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
	
	public Move getBestMove(Board board, Player player) {
		Move bestMove = null;
		
		Player otherPlayer = game.getOtherPlayer(player);
        ArrayList<Move> availableMoves = board.getAvailableMoves();
        int bestScore = getDefaultBestScore(player);

        for(int space = 0; space < availableMoves.size(); space++){
            Board boardClone = board.copy();
            boardClone.update(player.getMarker(), availableMoves.get(space));
            int currentScore = minimax(boardClone, otherPlayer);
            boolean isBestScore = isBestScore(currentScore, bestScore, player);
            if(isBestScore){
                bestScore = currentScore;
                bestMove = availableMoves.get(space);
            }
        }
        return bestMove;
	}
	
	public int minimax(Board board, Player player){
        if(board.isWinner(game.getPlayer1().getMarker())) return 1;
        if(board.isWinner(game.getPlayer2().getMarker())) return -1;
        if(board.isDraw()) return 0;

        return generateMoveTree(board, player);
    }

	private int generateMoveTree(Board board, Player player) {
		Player otherPlayer = game.getOtherPlayer(player);
        ArrayList<Move> availableMoves = board.getAvailableMoves();
        int bestScore = getDefaultBestScore(player);

        for(int space = 0; space < availableMoves.size(); space++){
            Board boardClone = board.copy();
            boardClone.update(player.getMarker(), availableMoves.get(space));
            int score = minimax(boardClone, otherPlayer);
            boolean isBestScore = isBestScore(score, bestScore, player);
            if(isBestScore)
                bestScore = score;
        }
        return bestScore;
	};

}
