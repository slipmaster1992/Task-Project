package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

	
    @Transactional
  	@Modifying
  	@Query("UPDATE Customer cust SET cust.custName = :custName , cust.password = :password , cust.email = :email, cust.address = :address WHERE cust.id =:id")
  	public void updateCustomer(@Param("custName") String custName ,@Param("password") String password , @Param("email") String email ,@Param("address")String address ,@Param("id") long id);

	
    Customer findById(long id); 
    
    
    Customer findCustomerByCustName(String name);
    
    
    boolean existsByEmailAndPassword (String email , String password);
    
    boolean existsByEmail(String email);
    
    
    
    
}
