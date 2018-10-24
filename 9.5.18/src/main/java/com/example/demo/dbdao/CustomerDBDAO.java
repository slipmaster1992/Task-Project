package com.example.demo.dbdao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Customer;
import com.example.demo.repo.CustomerRepo;

@Component
public class CustomerDBDAO implements CustomerDAO {

	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public void createCustomer(Customer customer) {
		customerRepo.save(customer);
		
	}

	@Override
	public void removeCustomer(Customer customer) {
		customerRepo.delete(customer);
		
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		Iterable<Customer> getAllCustomers = customerRepo.findAll();
		return getAllCustomers;
	}

	@Override
	public void updateCustomer(String custName, String password, String email, String address, long id) {
		
		
		customerRepo.updateCustomer(custName, password, email, address, id);
		
	}
	
	
	
	public Customer getCustomerBYName(String name) {
		
	Customer cust = customerRepo.findCustomerByCustName(name);
	return cust;
		
	
	}
	
	public Customer getCustomerById(long id) {
		
		Customer cust = customerRepo.findById(id);
		return cust;
		
	}
	
	 
	public boolean existByEmail(String email) {
		
		boolean check = customerRepo.existsByEmail(email);
		if(check) {
			
		return true;
		}
		return false;
	}
	
	
	public boolean login(String email, String password) {
		   
		   
		   boolean check = customerRepo.existsByEmailAndPassword(email, password);
		   
		   if(check) {
			   
			   return true;
			   
		   }
		return false;
		   
	   }
	
	
}
