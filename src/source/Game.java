package source;

import java.util.Scanner;

public class Game {
	private Board board;
	private Player player1, player2, currentPlayer;
	public boolean active;

	public Game(Board board, Player player1, Player player2) {
		this.board = board;
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setCurrentPlayer(player1);
		active = true;
	}

	public Player getOtherPlayer(Player player) {
		if (player == getPlayer1())
			return getPlayer2();
		return getPlayer1();
	}
	
	public void takeTurn(Player player, Move move) {
		board.update(player.getMarker(), move);
	}
	
	public void nextTurn() {
		setCurrentPlayer(getOtherPlayer(getCurrentPlayer()));
	}
	
	public void printState() {
		if(board.isWinner("X")) System.out.println("X IS WINNER!");
		if(board.isWinner("O")) System.out.println("O IS WINNER!");
		if(board.isDraw()) System.out.println("IT'S A DRAW");
	}
	
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

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

		
}
