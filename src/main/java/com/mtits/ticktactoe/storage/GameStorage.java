package com.mtits.ticktactoe.storage;

import java.util.HashMap;
import java.util.Map;

import com.mtits.ticktactoe.model.Game;

public class GameStorage {
	
	private static Map<String, Game> games;
	private static GameStorage instance;

	private GameStorage() {
		games = new HashMap<>();
	}
	
	public static synchronized GameStorage getInstance() {
		if(instance == null) {
			instance =  new GameStorage();
		}
		return instance;
	}
	
	public static Map<String, Game> getGames() {
		
		return games;
	}
	
	public static void setGame(Game game) {
		games.put(game.getGameId(), game);
	}
}
