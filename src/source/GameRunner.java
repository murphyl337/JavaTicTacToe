package source;

public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Player player1 = new Player();
		Player player2 = new Player();
		Board board = new Board(player1, player2);
		System.out.println(board.print());

	}

}
