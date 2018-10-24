package com.example.demo.facades;



import java.util.Date;

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
import com.example.demo.exceptions.CustomerAlreadyExistException;
import com.example.demo.exceptions.TaskAlreadyExistException;
import com.example.demo.exceptions.TaskNotExistException;



@Component
@Scope ("singleton")
public class AdminFacade implements ClientFacade{

	
	@Autowired
	CustomerDBDAO custDB;
	
	@Autowired
	
	TaskDBDAO taskDB;
	
	@Autowired
	TransactionDBDAO transactionDB;
	
	public AdminFacade() {
		
		super();
		
	}
	
	
	public void createTask(Task task) {
		
	Transaction transaction = new Transaction(CustomerType.ADMIN, SystemVariables.adminUserName, ActionType.CREATE, ComponentType.TASK, task.toString(), false, SystemVariables.taskExistException);
		
	if(taskDB.existByDescription(task.getDescription())) {
		
	transactionDB.createTransaction(transaction);
		
	String message = String.format(ExceptionMessages.taskExistByDescriptionExceptionMessage, task.getDescription());
		
	throw new TaskAlreadyExistException(message);
		
		
	}
	
	taskDB.createTask(task);
		
	transaction.setSuccess(true);
	transaction.setException(SystemVariables.noExceptionMessage);
	transactionDB.createTransaction(transaction);
	
	
	System.out.printf(SystemVariables.taskCreatedSuccessfully, task);
	
	}
	
	
	
	
	public void removeTask(Task task) {
		
	Transaction transaction = new Transaction(CustomerType.ADMIN, SystemVariables.adminUserName, ActionType.REMOVE, ComponentType.TASK, task.toString(), false, SystemVariables.taskExistException);
		
	if(taskDB.getTaskById(task.getId()) == null) {
			
	transactionDB.createTransaction(transaction);
			
	String message = String.format(ExceptionMessages.taskNotExistByIdExceptionMessage, task.getId());
			
	throw new TaskNotExistException(message);
		}
		
		
    taskDB.removeTask(task);
		
	transaction.setSuccess(true);
	transaction.setException(SystemVariables.noExceptionMessage);
	transactionDB.createTransaction(transaction);
		
	System.out.printf(SystemVariables.taskRemovedSuccessfully, task);
		
		}
	
	
	
	public void updateTask(Task task) {
		
	Transaction transaction = new Transaction(CustomerType.ADMIN, SystemVariables.adminUserName, ActionType.UPDATE, ComponentType.TASK, task.toString(), false, SystemVariables.taskExistException);
		
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
	
	
	
	
	public void createCustomer(Customer customer) {
		
	Transaction transaction = new Transaction(CustomerType.ADMIN, SystemVariables.adminUserName, ActionType.CREATE, ComponentType.CUSTOMER, customer.toString(), false, SystemVariables.customerExistException); 
		
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
	
   
	
	
	public void removeCustomer(Customer customer) {
		
		Transaction transaction = new Transaction(CustomerType.ADMIN,SystemVariables.adminUserName, ActionType.REMOVE, ComponentType.CUSTOMER, customer.toString(), true, SystemVariables.noExceptionMessage);
		custDB.removeCustomer(customer);
		transactionDB.createTransaction(transaction);
		
		System.out.printf(SystemVariables.customerRemovedSuccessfully, customer);
		
	}

    
	
	public void updateCustomer(Customer customer) {
	
    	Transaction transaction = new Transaction(CustomerType.CUSTOMER, SystemVariables.adminUserName, ActionType.UPDATE, ComponentType.CUSTOMER, customer.toString(), true, SystemVariables.noExceptionMessage);
    	custDB.updateCustomer(customer.getCustName(), customer.getPassword(), customer.getEmail(), customer.getAddress(), customer.getId());
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


	
    @Override
	public ClientFacade login(String email, String password) {

    	if((password.equals("1234")) && (email.equals("admin"))){
			
			return this;
		}
		
		
		return null;
}
}
