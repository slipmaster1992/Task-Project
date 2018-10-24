package com.example.demo.exceptions;


@SuppressWarnings("serial")
public class CustomerAlreadyExistException extends RuntimeException{

  public CustomerAlreadyExistException(String message) {
	  
	  super(message);
	  
  }
	
	
}
