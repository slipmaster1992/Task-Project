package com.example.demo.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.common.ActionType;
import com.example.demo.common.ComponentType;
import com.example.demo.common.CustomerType;
import com.example.demo.common.ExceptionMessages;
import com.example.demo.common.SystemVariables;
import com.example.demo.dbdao.CustomerDBDAO;
import com.example.demo.dbdao.TransactionDBDAO;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Transaction;
import com.example.demo.exceptions.CustomerAlreadyExistException;

@Component
@Scope ("singleton")
public class NoLoginFacade {

	
	@Autowired
	CustomerDBDAO custDB;
	
	@Autowired
	TransactionDBDAO transactionDB;
	
	
	
	
	public NoLoginFacade() {
		
		super();
		
	}
	
	
	
	
	public void createCustomer(Customer customer) {
		
		Transaction transaction = new Transaction(CustomerType.CUSTOMER, customer.toString(), ActionType.CREATE, ComponentType.CUSTOMER, customer.toString(), false, SystemVariables.noExceptionMessage);
		
		if(custDB.existByEmail(customer.getEmail())) {
			
			transactionDB.createTransaction(transaction);
			
			String message = String.format(ExceptionMessages.customerExistExceptionMessage, customer.getEmail());
			
			throw new CustomerAlreadyExistException(message);
			
			
		}
			
		custDB.createCustomer(customer);
			
	    transaction.setSuccess(true);
	    transaction.setException(SystemVariables.noExceptionMessage);
	    transactionDB.createTransaction(transaction);
	    
	    System.out.printf(SystemVariables.customerCreatedSuccessfully, customer);
			
		
	}
	
	
}
