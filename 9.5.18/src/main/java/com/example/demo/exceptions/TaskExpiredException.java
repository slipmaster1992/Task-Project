package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class TaskExpiredException extends RuntimeException{

	
	public TaskExpiredException(String message) {
		
		super(message);
		
	}
	
}
