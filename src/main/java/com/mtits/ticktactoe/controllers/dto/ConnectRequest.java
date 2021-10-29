package com.mtits.ticktactoe.controllers.dto;

import com.mtits.ticktactoe.model.Player;

import lombok.Data;

@Data
public class ConnectRequest {
	private Player player;
	private String gameId;
}
