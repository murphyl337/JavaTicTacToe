package source;

import java.util.ArrayList;

import source.Position;

public class Board {
	private String[][] state = new String[3][3];

	public Board() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				setSpace(row, col, "");
		}
	}

	public String getSpace(int row, int col){
		return state[row][col]; 
	}
	
	public void setSpace(int row, int col, String marker){
		state[row][col] = marker;
	}
		
	public void setSpace(Position position, String marker) {
		state[position.row][position.col] = marker;
	}
	
	public ArrayList<Position> getAvailablePositions() {
		ArrayList<Position> availablePositions = new ArrayList<Position>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (getSpace(row,col).equals("")) {
					Position position = new Position(row, col);
					availablePositions.add(position);
				}
			}
		}
		return availablePositions;
	}
	
	public Board copy() {
		Board copy = new Board();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				copy.setSpace(row, col, this.getSpace(row, col));
		}
		return copy;
	}
}
