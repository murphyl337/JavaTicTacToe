package source.TTT;

public class Position{
	public int row;
	public int col;
	
	public Position(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public Position(String row, String col){
		this.row = Integer.parseInt(row);
		this.col = Integer.parseInt(col);
	}
	
	public Position(String rowCommaCol){
		String[] positionString = rowCommaCol.split(",");
		this.row = Integer.parseInt(positionString[0]);
		this.col = Integer.parseInt(positionString[1]);
	}
}