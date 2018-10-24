package com.example.demo.dbdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Transaction;
import com.example.demo.repo.TransactionRepo;

@Component
@Scope("prototype")
public class TransactionDBDAO {

	
	@Autowired
	TransactionRepo transactionRepo;
	
	
	
	public TransactionDBDAO() {
		
		super();
		
	}
	
	
	
	
	public void createTransaction(Transaction transaction) {
		
		
		transactionRepo.save(transaction);
		
	}
	
	
}
