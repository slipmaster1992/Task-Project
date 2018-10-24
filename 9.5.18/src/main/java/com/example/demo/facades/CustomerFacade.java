package com.example.demo.facades;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.common.ActionType;
import com.example.demo.common.ComponentType;
import com.example.demo.common.CustomerType;
import com.example.demo.common.ExceptionMessages;
import com.example.demo.common.SystemVariables;
import com.example.demo.common.TaskType;
import com.example.demo.dbdao.CustomerDBDAO;
import com.example.demo.dbdao.TaskDBDAO;
import com.example.demo.dbdao.TransactionDBDAO;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Task;
import com.example.demo.entities.Transaction;
import com.example.demo.exceptions.TaskAlreadyExistException;
import com.example.demo.exceptions.TaskNotExistException;

@Component
@Scope ("singleton")
public class CustomerFacade implements ClientFacade {

	
	
	@Autowired
	CustomerDBDAO custDB;
	
	@Autowired
	
	TaskDBDAO taskDB;
	
	@Autowired
	TransactionDBDAO transactionDB;

	private long customerId;
	
	
	
	
	
	
	@Override
	public ClientFacade login(String email,String password) {
		
		
		
		if(custDB.login(email, password) == true) {
			customerId = custDB.getCustomerBYName(email).getId();
			return this;
		}
		return null;
			
		
	}
	
	
	
	
	

	public void createTask(Task task) {
	
		Customer customer = custDB.getCustomerById(customerId);
		
		Transaction transaction = new Transaction(CustomerType.CUSTOMER, customer.toString(), ActionType.CREATE, ComponentType.TASK, task.toString(), false, SystemVariables.taskExistException);
		
		if(taskDB.existByDescription(task.getDescription())) {
			
			transactionDB.createTransaction(transaction);
			
			String message = String.format(ExceptionMessages.taskExistByDescriptionExceptionMessage, task.getDescription());
			
			throw new TaskAlreadyExistException(message);
			
			
		}
		
		task.setCustomer(customer);
		taskDB.createTask(task);
			
		transaction.setSuccess(true);
		transaction.setException(SystemVariables.noExceptionMessage);
		transactionDB.createTransaction(transaction);
		
		
		System.out.printf(SystemVariables.taskCreatedSuccessfully, task);
		
		
		}
	

	
	
	
	public void removeTask(Task task) {
		
		Customer customer = custDB.getCustomerById(customerId);
	
		Transaction transaction = new Transaction(CustomerType.CUSTOMER, customer.toString(), ActionType.REMOVE, ComponentType.CUSTOMER, customer.toString(), true, SystemVariables.noExceptionMessage);
		
	     taskDB.removeTask(task);
		
		transactionDB.createTransaction(transaction);
		
		System.out.printf(SystemVariables.taskRemovedSuccessfully, task);

	
	}
	
	
	
	public void updateTask(Task task) {
	
		Customer customer = custDB.getCustomerById(customerId);
		Transaction transaction = new Transaction(CustomerType.CUSTOMER, customer.toString(), ActionType.UPDATE, ComponentType.TASK, task.toString(), false, SystemVariables.taskNotExistException);
		
		if(taskDB.getTaskById(task.getId()) == null) {
			
			transactionDB.createTransaction(transaction);
			
			String message = String.format(ExceptionMessages.taskNotExistByIdExceptionMessage, task.getId());
			
			throw new TaskNotExistException(message);
		}
		
		
		taskDB.updateTask(task.getDescription(), task.getStartDate(), task.getEndDate(), task.getPrice(), task.getAddress(), task.getId());
		transaction.setSuccess(true);
		transaction.setException(SystemVariables.noExceptionMessage);
		transactionDB.createTransaction(transaction);
		
		
		System.out.printf(SystemVariables.taskUpdatedSuccessfully, task);
		
	
	}
	
	
	public Iterable<Task> getAllTasks(){
		
		Iterable<Task> getAllTasks = taskDB.getAllTasks();
		return getAllTasks;
		
	}
	

	public void removeCustomer(Customer customer) {
		
		Customer cust = custDB.getCustomerById(customerId);
		Transaction transaction = new Transaction(CustomerType.CUSTOMER, cust.toString(), ActionType.REMOVE, ComponentType.CUSTOMER, cust.toString(), true, SystemVariables.noExceptionMessage);
		custDB.removeCustomer(customer);
		taskDB.removeAllCustomerTasks(customer.getId());
		transactionDB.createTransaction(transaction);
		
		
		System.out.printf(SystemVariables.customerRemovedSuccessfully, customer);
		
	}

   
	public void updateCustomer(Customer customer) {
    	Customer cust= custDB.getCustomerById(customerId);
    	Transaction transaction = new Transaction(CustomerType.CUSTOMER, cust.toString(), ActionType.UPDATE, ComponentType.CUSTOMER, cust.toString(), true, SystemVariables.noExceptionMessage);
    	custDB.updateCustomer(customer.getCustName(), customer.getPassword(), customer.getEmail(), customer.getAddress(), customerId);
    	transactionDB.createTransaction(transaction);
    
    	System.out.printf(SystemVariables.customerUpdatedSuccessfully, customer);
 
	}
	
	
	public Iterable<Customer> getAllCustomers(){
		
		Iterable<Customer> getAllCustomers = custDB.getAllCustomers();
		return getAllCustomers;
		
	}


	
	public Customer getCustomerByName(String name) {
		
		Customer cust = custDB.getCustomerBYName(name);
		return cust;
		
	}
	
	
	public Customer getCustomerById(long id) {
	
		Customer cust = custDB.getCustomerById(id);
		return cust;
		
	}
	
	
	
	public Task getTaskById(long id) {
		
		Task task = taskDB.getTaskById(id);
		return task;
		
	}
	
	
	
	public Iterable<Task> getTasksByDates(Date startDate,Date endDate){
		
		Iterable<Task> getTasksByDates = taskDB.getAllTasksByDates(startDate, endDate);
		return getTasksByDates;
		
	}
	
	
	public Iterable<Task> getAllTasksByPrices(double minPrice, double maxPrice){
		
		Iterable<Task> getAllTaskskByPrices = taskDB.getAllTasksByPrices(minPrice, maxPrice);
		return getAllTaskskByPrices;
		
		
	}
	
	
    public Iterable<Task> getAllTasksByType(TaskType type){
		
		Iterable<Task> getAllTaskskByType = taskDB.getAllTasksByType(type);
		return getAllTaskskByType;
		
		
	}

	
	
}
