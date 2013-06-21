package source.handles;

import source.TTT.Game;
import source.TTT.Player;
import source.TTT.Position;

public interface StrategyHandle {
	public void setGame(Game game);
	public void setPlayer(Player player);
	public Position getMove();
}
