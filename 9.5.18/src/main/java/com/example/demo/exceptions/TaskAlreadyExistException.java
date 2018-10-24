package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class TaskAlreadyExistException extends RuntimeException {

	
	
	public TaskAlreadyExistException(String message) {
		
		super(message);
		
	}
	
}
