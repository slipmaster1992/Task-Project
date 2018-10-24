package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.exceptions.CustomerAlreadyExistException;
import com.example.demo.facades.NoLoginFacade;

@RestController
@CrossOrigin("*")
public class NoLoginWebService {

	
	
	@Autowired
	
	NoLoginFacade nlf;
	
	
	
	@RequestMapping(value = "/nologinweb/createcustomer" , method = RequestMethod.POST , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void createTask(HttpServletRequest request ,@RequestBody Customer customer)  {
	
	
	  
	   try {
	   nlf.createCustomer(customer);
		 
	}catch (CustomerAlreadyExistException e) {
		
		System.out.println(e.getMessage());
		
	}
	
	}
	
	
	
}
