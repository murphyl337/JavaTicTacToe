package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import source.TTT.ArtificialIntelligence;
import source.TTT.Board;
import source.TTT.Game;
import source.TTT.GameRules;
import source.TTT.Player;
import source.TTT.Position;

public class AITest {
	Player player1, player2;
	Board board;
	Game game;
	GameRules rules;
	ArtificialIntelligence ai;
	Position move;
	
	@Before
	public void before(){
		player1 = new Player("X", "human");
		player2 = new Player("O", "human");
		board = new Board();
		game = new Game(board, player1, player2);
		ai = new ArtificialIntelligence(game);
		move = new Position(0,0);
	}

	@Test
	public void defaultBestScoreIsIntMaxForP1IntMinForP2(){
		int bestScore = ai.getDefaultBestScore(player1);
		assertEquals(Integer.MIN_VALUE, bestScore);
		
		bestScore = ai.getDefaultBestScore(player2);
		assertEquals(Integer.MAX_VALUE, bestScore);
	}
	
	@Test
	public void isBestScoreForPlayer1IsTrueForScoreGreaterThanBestScore(){
		int score = 1;
		int bestScore = ai.getDefaultBestScore(player1);
		
		assertTrue(ai.isBestScore(score, bestScore, player1));
	}
	
	@Test
	public void isBestScoreForPlayer2IsTrueForScoreLessThanBestScore(){
		int score = -1;
		int bestScore = ai.getDefaultBestScore(player2);
		
		assertTrue(ai.isBestScore(score, bestScore, player2));
	} 
	
	@Test
	public void getBestMoveReturnsCenterSpaceWhenCornerIsTaken(){
		game.takeTurn(player1, move);
		
		move = ai.getBestMove(game.getBoard(), player2);

		assertEquals(1, move.row);
		assertEquals(1, move.col);
	}
	
	@Test
	public void getBestMoveIsWinningMove(){
		board.setSpace(move, "X");
		move = new Position(0,1);
		board.setSpace(move, "X");
		move = new Position(1,0);
		board.setSpace(move, "X");
		move = new Position(1,1);
		board.setSpace(move, "O");
		move = new Position(2,0);
		board.setSpace(move, "O");
		
		move = ai.getBestMove(board, player2);
		assertEquals(0, move.row);
		assertEquals(2, move.col);
	}
}
