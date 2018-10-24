package com.example.demo.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.CustomerType;
import com.example.demo.common.TaskType;
import com.example.demo.core.LoginSystem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Task;
import com.example.demo.exceptions.TaskAlreadyExistException;
import com.example.demo.exceptions.TaskNotExistException;
import com.example.demo.facades.CustomerFacade;



 
    @CrossOrigin("*")
    @RestController
    public class CustomerWebService {

	
 	
    @Autowired LoginSystem 
    loginSystem;
	
	public CustomerFacade getFacade() {
		
		CustomerFacade cf;
		
	try {	
	 	cf = (CustomerFacade) loginSystem.login("Bill", "1234", CustomerType.CUSTOMER);
	   return cf;
	} catch (Exception e) {
		return null;
	}
	}
	
	
	
	
	
	@RequestMapping(value = "/customerweb/createtask" , method = RequestMethod.POST , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void createTask(HttpServletRequest request ,@RequestBody Task task)  {
	
	
	   CustomerFacade cf = getFacade();
	   try {
	   cf.createTask(task);
		 
	}catch (TaskAlreadyExistException e) {
		
		System.out.println(e.getMessage());
		
	}
	
	}
	
	
	
	
	
	@RequestMapping(value = "/customerweb/removetask" , method = RequestMethod.PATCH , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void removeTask(HttpServletRequest request ,@RequestBody Task task)  {
	
	
	   CustomerFacade cf = getFacade();
	   
	   cf.removeTask(task);
		 
	}
	
	
	
	

	@RequestMapping(value = "/customerweb/updatetask" , method = RequestMethod.PUT , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void updteTask(HttpServletRequest request ,@RequestBody Task task)  {
	
	
	   CustomerFacade cf = getFacade();
	   try {
	   cf.createTask(task);
		 
	}catch (TaskNotExistException e) {
		
		System.out.println(e.getMessage());
		
	}
	
	}
	
	
	
	
	
	@RequestMapping(value = "/customerweb/getalltasks" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Task> getAllTasks()   {
	
		 CustomerFacade cf = getFacade();
		return cf.getAllTasks();
	
	}
	
	
	
	
	
	@RequestMapping(value = "/customerweb/removecustomer" , method = RequestMethod.PATCH , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void removeCustomer(HttpServletRequest request ,@RequestBody Customer customer)  {
	
	
	   CustomerFacade cf = getFacade();
	   
	   cf.removeCustomer(customer);
		 
	}
	
	
	

	
	@RequestMapping(value = "/customerweb/updatecustomer" , method = RequestMethod.PUT , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(HttpServletRequest request ,@RequestBody Customer customer)  {
	
	
	   CustomerFacade cf = getFacade();
	   
	   cf.updateCustomer(customer);
		 
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/customerweb/getallcustomers" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> getAllCustomers()  {
	
		 CustomerFacade cf = getFacade();
		return cf.getAllCustomers();
	
	}
	
	
	

	
	
	
	
	@RequestMapping(value = "/customerweb/getcustomerbyname/{name}" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerByName(HttpServletRequest request ,@PathVariable("name") String name)  {
	
		 CustomerFacade cf = getFacade();
		return cf.getCustomerByName(name);
	
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/customerweb/getcustomerbyid/{id}" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(HttpServletRequest request ,@PathVariable("id") long id)  {
	
		 CustomerFacade cf = getFacade();
		return cf.getCustomerById(id);
	
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/customerweb/gettaskbyid/{id}" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskById(HttpServletRequest request ,@PathVariable("id") long id)  {
	
		 CustomerFacade cf = getFacade();
		return cf.getTaskById(id);
	
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/customerweb/getalltasksbydates/{startDate},{endDate}" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Task> getAllTasksByDates(HttpServletRequest request, @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date startDate, @PathVariable("endDate")  @DateTimeFormat(pattern = "yyyy-MM-dd")  Date endDate)  {
	
		 CustomerFacade cf = getFacade();
		return cf.getTasksByDates(startDate, endDate);
	
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/customerweb/getalltasksbyprices/{minPrice},{maxPrice}" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Task> getAllTasksByPrices(HttpServletRequest request, @PathVariable("minPrice") double minPrice, @PathVariable("maxPrice") double maxPrice)  {
	
		 CustomerFacade cf = getFacade();
		return cf.getAllTasksByPrices(minPrice, maxPrice);
	
	}
	
	
	
	
	
	
	@RequestMapping(value = "/customerweb/getalltasksbytype/{type}" , method = RequestMethod.GET, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Task> getAllTasksByType(HttpServletRequest request, @PathVariable("type") TaskType type)  {
	
		 CustomerFacade cf = getFacade();
		return cf.getAllTasksByType(type);
	
	}
	
	
	
	}
