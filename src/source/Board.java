package source;

import java.util.ArrayList;


public class Board {
	public String [] state = new String[9];
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public Board(Player player1, Player player2){
		players.add(player1);
		players.add(player2);
	}

}
