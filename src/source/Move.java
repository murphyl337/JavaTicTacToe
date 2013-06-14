package source;

public class Move{
	public int row;
	public int col;
	
	public Move(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public Move(String row, String col){
		this.row = Integer.parseInt(row);
		this.col = Integer.parseInt(col);
	}
}