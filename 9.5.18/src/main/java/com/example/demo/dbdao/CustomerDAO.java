package com.example.demo.dbdao;



import com.example.demo.entities.Customer;

public interface CustomerDAO {

	
	void createCustomer(Customer customer);
	
	void removeCustomer(Customer customer);
	
	Iterable<Customer> getAllCustomers();
	
	void updateCustomer(String custName,String password,String email,String address,long id);
}
