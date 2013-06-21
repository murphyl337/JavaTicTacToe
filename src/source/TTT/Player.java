package source.TTT;

import source.handles.StrategyHandle;

public class Player {
	private String marker;
	private StrategyHandle strategyHandle;

	public Player(String marker, StrategyHandle stratHandle) {
		this.marker = marker;
		this.strategyHandle = stratHandle;
	}

	public void makeMove(Game game){
		strategyHandle.setGame(game);
		strategyHandle.setPlayer(this);
		Position move = strategyHandle.getMove();
		game.updateBoard(this, move);
	}
	
	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public StrategyHandle getStrategyHandle() {
		return strategyHandle;
	}

	public void setStrategyHandle(StrategyHandle strategyHandle) {
		this.strategyHandle = strategyHandle;
	}

}
