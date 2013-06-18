package source;

import java.util.ArrayList;

import source.Move;

public class Board {
	private String[][] state = new String[3][3];

	public Board() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				state[row][col] = "";
		}
	}

	public Board copy() {
		Board copy = new Board();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				copy.state[row][col] = this.state[row][col];
		}
		return copy;
	}

	public String getSpace(int row, int col){
		return state[row][col]; 
	}
	
	public void setSpace(int row, int col, String marker){
		state[row][col] = marker;
	}
		
	public void update(String marker, Move move) {
		state[move.row][move.col] = marker;
	}

	public void printTemplateBoard(){
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + row + " , " + col + "]");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				sb.append("[" + state[row][col] + "]");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public ArrayList<Move> getAvailableMoves() {
		ArrayList<Move> availableMoves = new ArrayList<Move>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (state[row][col].equals("")) {
					Move move = new Move(row, col);
					availableMoves.add(move);
				}
			}
		}
		return availableMoves;
	}
}
