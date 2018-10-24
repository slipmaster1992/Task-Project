package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class WrongEmailOrPasswordException extends RuntimeException {


	public WrongEmailOrPasswordException(String message) {
		
		super(message);
		
	}

}
