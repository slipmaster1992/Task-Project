package com.example.demo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.common.CustomerType;
import com.example.demo.facades.AdminFacade;
import com.example.demo.facades.ClientFacade;
import com.example.demo.facades.CustomerFacade;


@Component
@Scope("singleton")
public class LoginSystem {

	
	public LoginSystem() {
		
		super();
		
	}
	
	
	@Autowired
	AdminFacade af;
	
	@Autowired
	CustomerFacade cf;
	
	
	

	public ClientFacade login(String email, String password, CustomerType customerType)
	{
		switch (customerType)
		{
		case ADMIN:
			AdminFacade result =  (AdminFacade) af.login(email, password);
			return (ClientFacade) result;
		
		case CUSTOMER: 
			CustomerFacade custResult = (CustomerFacade)cf.login(email, password);				
			return (ClientFacade) custResult;

		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
