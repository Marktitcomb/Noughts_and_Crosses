package com.mtits.ticktactoe.model;

import java.util.UUID;

import lombok.Data;

@Data
public class Game {//the entity sent back to the front end 
	
	private String gameId;
	private Player player1;
	private Player player2;
	private GameStatus status;
	private int[][] board;
	private TicToe winner;
	
	public Game() {
		
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public TicToe getWinner() {
		return winner;
	}

	public void setWinner(TicToe winner) {
		this.winner = winner;
	}

	public GameStatus getStatus() {
		return status;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setBoard(int[][] layout) {
		this.board = layout;
	}

	public void setGameId(String id) {
		this.gameId = id;
		
	}


	public void setStatus(GameStatus status) {
		this.status = status;
		
	}

	public String getGameId() {
		return this.gameId;
	}

	public Object getPlayer2() {
		return player2;
	}
	
	
	

}
