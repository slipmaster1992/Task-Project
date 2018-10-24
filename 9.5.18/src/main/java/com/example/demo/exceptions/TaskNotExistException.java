package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class TaskNotExistException extends RuntimeException {

	
	public TaskNotExistException(String message) {
		
		super(message);
		
	}
	
}


