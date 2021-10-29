package com.mtits.ticktactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicToe {
    X(1), O(2);

	private final int num;

	
	public int getValue() {
		return num;
	}
}
