package source.console;

import source.TTT.Board;
import source.TTT.Game;
import source.TTT.GameRules;

public class ConsoleWriter {
	public void printGreeting() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to Tic Tac Toe!\n");
		sb.append("What configuration of players would you like to play with?\n");
		sb.append("H: Human | C: Computer\n");
		sb.append("HvH, CvC, HvC, or CvH?  (case does not matter)");
		System.out.println(sb.toString());
	}
	
	public void printTemplateBoard(){
		System.out.println("These are the moves you can make: ");
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + row + "," + col + "]");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public void printGameState(Game game){
		if(GameRules.isWinner("X", game.getBoard()))
			System.out.println("X IS WINNER!");
		else if(GameRules.isWinner("O", game.getBoard()))
			System.out.println("O IS WINNER!");
		else if(GameRules.isDraw(game.getBoard()))
			System.out.println("IT'S A DRAW!");
			
	}
	
	public void printBoard(Board board){
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + board.getSpace(row,col) + "]");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
