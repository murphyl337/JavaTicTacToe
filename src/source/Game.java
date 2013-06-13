package source;

import source.Game.Move;

public class Game {
	private Board board;
	
	public class Move{
		public int row;
		public int col;
		
		public Move(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	public Game(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		// TODO Auto-generated method stub
		return this.board;
	}

	public void takeTurn(Player player, Move move) {
		getBoard().state[move.row][move.col] = player.getMarker();
	}

	public boolean isWinner(String marker) {
		return isWinnerHorizontally(marker);
	}

	public boolean isWinnerHorizontally(String marker) {
		boolean winner = true;

		for(int col=0; col<3; col++){
			if(!board.state[0][col].equals(marker))
				winner = false;
		}

		return winner;
	}

}
