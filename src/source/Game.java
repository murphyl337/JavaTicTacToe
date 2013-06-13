package source;

import java.util.ArrayList;

import source.Move;

public class Game {
	private Board board;
	private Player player1, player2;
	public boolean active;

	public Game(Board board, Player player1, Player player2) {
		this.board = board;
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		active = true;
	}

	public void takeTurn(Player player, Move move) {
		board.update(player.getMarker(), move);
	}

	public Player getOtherPlayer(Player player) {
		if (player == getPlayer1())
			return getPlayer2();
		return getPlayer1();
	}

	public int getDefaultBestScore(Player player) {
		if (player == getPlayer1())
			return Integer.MIN_VALUE;
		return Integer.MAX_VALUE;
	}

	public boolean isBestScore(int score, int bestScore, Player player) {
		boolean isBestScore = false;
		if (player == getPlayer1()) {
			if (score > bestScore)
				isBestScore = true;
		} else if (player == getPlayer2()) {
			if (score < bestScore)
				isBestScore = true;
		}
		return isBestScore;
	}
	
	public Move getBestMove(Board board, Player player) {
		Player otherPlayer = getOtherPlayer(player);
        ArrayList<Move> availableMoves = board.getAvailableMoves();
        Move bestMove = null;
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
        if(board.isWinner(getPlayer1().getMarker())) return 1;
        if(board.isWinner(getPlayer2().getMarker())) return -1;
        if(board.isDraw()) return 0;

        Player otherPlayer = getOtherPlayer(player);
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

	public Board getBoard() {
		return board;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	
}
