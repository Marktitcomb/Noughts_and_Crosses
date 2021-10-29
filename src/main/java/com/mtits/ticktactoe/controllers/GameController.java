package com.mtits.ticktactoe.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtits.ticktactoe.controllers.dto.ConnectRequest;
import com.mtits.ticktactoe.exceptions.InvalidGameException;
import com.mtits.ticktactoe.exceptions.InvalidParamException;
import com.mtits.ticktactoe.exceptions.NotFoundException;
import com.mtits.ticktactoe.model.Game;
import com.mtits.ticktactoe.model.GamePlay;
import com.mtits.ticktactoe.model.Player;
import com.mtits.ticktactoe.service.GameService;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {

	private final GameService gameService;
	private final SimpMessagingTemplate simpMessagingTemplate;

	/**
	 * {
	 * 		"login": "player1name"
	 * }
	 * 
	 * */
	@PostMapping("/start")
	public ResponseEntity<Game> start(@RequestBody Player player) {
		log.info("start game request: {}", player);
		return ResponseEntity.ok(gameService.createGame(player));
	}
    /**{
        "player":{
            "login": "java-player2"
        } ,
        "gameId": "e2db9233-60d0-40bb-880e-2aabfc1bb077"
    }*/
	@PostMapping("/connect")
	public ResponseEntity<Game> connect(@RequestBody ConnectRequest request)
			throws InvalidParamException, InvalidGameException {
		log.info("connect request: {}", request);
		return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
	}

	@PostMapping("/connect/random")
	public ResponseEntity<Game> connectRandom(@RequestBody Player player) throws NotFoundException {
		log.info("connect random {}", player);
		return ResponseEntity.ok(gameService.connectToRandomGame(player));
	}

	@PostMapping("/gameplay")//remember your JSON has to match the object fields 
	public ResponseEntity<Game> gamePlay(@RequestBody GamePlay request) throws NotFoundException, InvalidGameException {
		log.info("gameplay: {}", request);
		Game game = gameService.gamePlay(request);
		//a browser listens to this topic with this game id to see status 
		simpMessagingTemplate.convertAndSend("/topic/game-progress/" + game.getGameId(), game);
		return ResponseEntity.ok(game);
	}

}
