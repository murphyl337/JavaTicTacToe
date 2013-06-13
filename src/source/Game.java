package source;

import java.util.ArrayList;

import source.Move;

public class Game {
	private Board board;
	private Player player1, player2;

	public Game(Board board, Player player1, Player player2) {
		this.board = board;
		this.setPlayer1(player1);
		this.setPlayer2(player2);
	}

	public Board getBoard() {
		return board;
	}

	public void takeTurn(Player player, Move move) {
		getBoard().state[move.row][move.col] = player.getMarker();
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
