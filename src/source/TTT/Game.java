package source.TTT;

public class Game {
	private GameRules rules;
	private Board board;
	private ArtificialIntelligence artificialIntelligence;

	private Player player1, player2, currentPlayer;

	public Game(Board board, Player player1, Player player2) {
		this.board = board;
		this.artificialIntelligence = new ArtificialIntelligence(this);
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
	}

	public Player getOtherPlayer(Player player) {
		if (player == getPlayer1())
			return getPlayer2();
		return getPlayer1();
	}

	public void takeTurn(Player player, Position move) {
		board.setSpace(move, player.getMarker());
	}

	public void nextTurn() {
		setCurrentPlayer(getOtherPlayer(getCurrentPlayer()));
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

	public GameRules getRules() {
		return rules;
	}

	public void setRules(GameRules rules) {
		this.rules = rules;
	}

	public ArtificialIntelligence getArtificialIntelligence() {
		return artificialIntelligence;
	}

	public void setArtificialIntelligence(ArtificialIntelligence ai) {
		this.artificialIntelligence = ai;
	}

}