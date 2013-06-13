package source;

import java.util.ArrayList;


public class Board {
	public String [][] state = new String[3][3];
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public Board(Player player1, Player player2){
		players.add(player1);
		players.add(player2);
		
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++)
				state[row][col] = "";
		}
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		for( int row=0; row<3; row++ ){
			for(int col=0; col<3; col++){
				sb.append("[" + state[row][col] + "]");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
