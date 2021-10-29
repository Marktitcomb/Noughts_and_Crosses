package com.mtits.ticktactoe.exceptions;

public class InvalidParamException extends RuntimeException{
	
	public String message;
	
	public InvalidParamException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
