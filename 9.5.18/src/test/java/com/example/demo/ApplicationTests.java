package com.example.demo;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.CustomerType;
import com.example.demo.common.DateMaker;
import com.example.demo.common.Gender;
import com.example.demo.common.TaskType;
import com.example.demo.core.LoginSystem;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Task;
import com.example.demo.facades.AdminFacade;
import com.example.demo.facades.CustomerFacade;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	
	@BeforeClass
	public static void beforeEverything()
	{
		System.out.println("########################");
	}

	@AfterClass
	public static void afterEverything()
	{
		System.out.println("########################");
	}
	
	
	@Autowired
	AdminFacade af;
	
	
	
	@Autowired LoginSystem loginSystem;
	
	public CustomerFacade getFacade() {
		
		CustomerFacade cf;
		
	try {	
	 	cf = (CustomerFacade) loginSystem.login("Neta", "1234", CustomerType.CUSTOMER);
	   return cf;
	} catch (Exception e) {
		return null;
	}
	}
	
	
	
	@Test
	public void contextLoads() {
		
		
		
		
		
    
//		Customer cust1 = new Customer(1,"Neta","1234","Neta","Hong Kong",Gender.FEMALE);
//		af.createCustomer(cust1);
//		
//		Customer cust2 = new Customer("Bill","1234","Bill","Chicago",Gender.MALE);
//		af.createCustomer(cust2);
//		
//
//		Customer cust3 = new Customer("James","1234","James","Los Angeles",Gender.MALE);
//		af.createCustomer(cust3);
//		
//		Customer cust4 = new Customer("Laurie","1234","Laurie","Atlanta",Gender.FEMALE);
//		af.createCustomer(cust4);
//		
//
//		CustomerFacade cf = getFacade();
//		
//		
//		Task task1 = new Task( "bkb","Photo Service For Wedding",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2018, 11, 12),300,"dd",TaskType.PHOTO_SERVICE);
//		cf.createTask(task1);
//	    
//	    Task task2 = new Task("bkb","Guitar Lesson",DateMaker.dateHelper(2018, 3, 12),DateMaker.dateHelper(2018, 3, 13),200,"dd",TaskType.BEAUTY_SERVICE);
//	    cf.createTask(task2);
//	    
//	    Task task3 = new Task("bkb","Surfing Lesson",DateMaker.dateHelper(2018, 5, 26),DateMaker.dateHelper(2018, 5, 26),150,"dd",TaskType.DESIGN_SERVICE);
//	    cf.createTask(task3);
//	    
//	    Task task4 = new Task("bkb","Cleaning Office",DateMaker.dateHelper(2018, 11, 21),DateMaker.dateHelper(2018, 11, 21),400,"dd",TaskType.CLEANING_SERVICE);
//	    cf.createTask(task4);
//	    
//	    Task task5 = new Task("bkb","Dog Sitter",DateMaker.dateHelper(2018, 1, 19),DateMaker.dateHelper(2018, 1, 29),600,"dd",TaskType.VIRTUAL_HELP);
//	    cf.createTask(task5);
//	    
//	    Task task6 = new Task("bkb","Building WebSite",DateMaker.dateHelper(2018, 8, 7),DateMaker.dateHelper(2018, 8, 12),5000,"dd",TaskType.COMPUTER_SERVICE);
//	    cf.createTask(task6);
//	    
//	    Task task7 = new Task("bkb","Robbing House",DateMaker.dateHelper(2018, 4, 13),DateMaker.dateHelper(2018, 4, 13),1400,"dd",TaskType.TRANSPORT_SERVICE);
//	    cf.createTask(task7);
		
	   
	//    cf.updateCustomer(cust1);;
//	    af.removeTask(task5);
	//    cf.removeCustomer(cust4);
//	cf.removeTask(task5);	
//	    af.removeCustomer(cust1);
		
		
//		Iterable<Task> getTasksByDates = cf.getTasksByDates(DateMaker.dateHelper(2018, 1, 1), DateMaker.dateHelper(2018, 11, 30));
//		System.out.println("Tasks: " + getTasksByDates);
		
//		Iterable<Task> getTasksByPrice = cf.getAllTasksByPrices(100, 400);
//		System.out.println("Tasks: " + getTasksByPrice);
		
		
//		Iterable<Task> getTasksByType = cf.getAllTasksByType(TaskType.BEAUTY_SERVICE);
//		System.out.println(getTasksByType);
		
		
//		Task task = cf.getTaskById(11);
//		System.out.println(task);
		
//		Customer cust = cf.getCustomerById(4);
//		System.out.println(cust);
//		
		
//		Customer cust = cf.getCustomerByName("James");
//		System.out.println(cust);
		
		
//		 Iterable<Customer> getAllcusts = cf.getAllCustomers();
//	     System.out.println("List Of Customers: " + getAllcusts);
		
		
		
//		Task task1 = new Task(11,"nnn",DateMaker.dateHelper(1995, 12, 22),DateMaker.dateHelper(2025, 1, 23),300,"Luna Park",TaskType.VIRTUAL_HELP);
//	    cf.updateTask(task1);
//		
		
		
//		Customer cust1 = new Customer("Neta Berger","1234","Neta Berger","Raanana",Gender.FEMALE);
//		cf.updateCustomer(cust1);
     
//		Customer cust1 = new Customer("Neta","1234","Neta","Moscow",Gender.FEMALE);
//		af.createCustomer(cust1);
//		
//		Customer cust2 = new Customer("Bill","1234","Bill","Chicago",Gender.MALE);
//		af.createCustomer(cust2);
//		
//
//		Customer cust3 = new Customer("James","1234","James","Los Angeles",Gender.MALE);
//		af.createCustomer(cust3);
//		
//		Customer cust4 = new Customer("Laurie","1234","Laurie","Atlanta",Gender.FEMALE);
//		af.createCustomer(cust4);
//		
//
//		CustomerFacade cf = getFacade();
//		
//		Task task1 = new Task("Photo Service For Wedding",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2018, 11, 12),300,"dd",TaskType.PHOTO_SERVICE);
//	    cf.createTask(task1);
//	    
//	    Task task2 = new Task("Guitar Lesson",DateMaker.dateHelper(2018, 3, 12),DateMaker.dateHelper(2018, 3, 13),200,"dd",TaskType.BEAUTY_SERVICE);
//	    cf.createTask(task2);
//	    
//	    Task task3 = new Task("Surfing Lesson",DateMaker.dateHelper(2018, 5, 26),DateMaker.dateHelper(2018, 5, 26),150,"dd",TaskType.DESIGN_SERVICE);
//	    cf.createTask(task3);
//	    
//	    Task task4 = new Task("Cleaning Office",DateMaker.dateHelper(2018, 11, 21),DateMaker.dateHelper(2018, 11, 21),400,"dd",TaskType.CLEANING_SERVICE);
//	    cf.createTask(task4);
//	    
//	    Task task5 = new Task("Dog Sitter",DateMaker.dateHelper(2018, 1, 19),DateMaker.dateHelper(2018, 1, 29),600,"dd",TaskType.VIRTUAL_HELP);
//	    cf.createTask(task5);
//	    
//	    Task task6 = new Task("Building WebSite",DateMaker.dateHelper(2018, 8, 7),DateMaker.dateHelper(2018, 8, 12),5000,"dd",TaskType.COMPUTER_SERVICE);
//	    cf.createTask(task6);
//	    
//	    Task task7 = new Task("Mooving House",DateMaker.dateHelper(2018, 4, 13),DateMaker.dateHelper(2018, 4, 13),1400,"dd",TaskType.TRANSPORT_SERVICE);
//	    cf.createTask(task7);
//		
//	    
//	    cf.removeTask(task6);
	    
	    
	    
	      
//		Iterable<Task> getAllTasksByType = af.getAllTasksByType(TaskType.LEGAL_HELP);
//		System.out.println(getAllTasksByType);
//		
		
//		Iterable<Task> getAllTasksByPrices = af.getAllTasksByPrices(300, 1200);
//		System.out.println(getAllTasksByPrices);
		
		
//		Iterable<Task> getTasksByDates = af.getTasksByDates(DateMaker.dateHelper(1990, 1, 1), DateMaker.dateHelper(2023, 1, 1));
//		System.out.println(getTasksByDates);
		
//		boolean check = af.login("lizliz@gmail.com", "1234");
//		System.out.println(check);
		
		
		
//		Task task = af.getTaskById(10);
//		System.out.println(task);
		
		
		
//		Customer cust = af.getCustomerById(2);
//		System.out.println(cust);
		
		
		
		
//		Customer cust = af.getCustomerByName("Sam");
//		System.out.println(cust);
		
		
		
		
//		Customer custx = new Customer(2,"Andy","5555","andybandy@yahoo.com","Wiskonsin",Gender.FEMALE);
//		
//		af.updateCustomer(custx);
//		
		
//		Task task1 = new Task(11,"nnn",DateMaker.dateHelper(1995, 12, 22),DateMaker.dateHelper(2025, 1, 23),300,"Luna Park",TaskType.VIRTUAL_HELP);
//		
//		
//		af.updateTask(task1);
//		
		
//		Customer cust1 = new Customer("Greg","1234","greg@gmail.com","Boston",Gender.MALE);
//	
//	    af.createCustomer(cust1);
//	    
//	    Customer cust2 = new Customer("George","1234","george@gmail.com","Moscow",Gender.MALE);
//		
//	    af.createCustomer(cust2);
//	    
//	    Customer cust3 = new Customer("Sam","1234","sam22@yahoo.com","Tel Aviv",Gender.MALE);
//		
//	    af.createCustomer(cust3);
//	    
//	    Customer cust4 = new Customer("Lizy","1234","lizliz@gmail.com","Los Angeles",Gender.FEMALE);
//		
//	    af.createCustomer(cust4);
//	    Customer cust5 = new Customer("Katy","1234","GGG@katy.com","San Paulo",Gender.FEMALE);
//		
//	    af.createCustomer(cust5);
//		
//	    af.removeCustomer(cust5);
//	    
//	    
//	    Iterable<Customer> getAllCustomers = af.getAllCustomers();
//	    	System.out.println(getAllCustomers);
//	 
//	     
//	    Task task1 = new Task("Wedding Haircut",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),1200,"dd",TaskType.BEAUTY_SERVICE);
//	    af.createTask(task1);
//	
//	    
//	    
//	    Task task2 = new Task("Truck Wash",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),500,"dd",TaskType.CLEANING_SERVICE);
//	    af.createTask(task2);
//	    
//	    
//	    Task task3 = new Task("Design room",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),260,"dd",TaskType.DESIGN_SERVICE);
//	    af.createTask(task3);
//	    
//	    
//	    Task task4 = new Task("Photo Service For Wedding",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),300,"dd",TaskType.PHOTO_SERVICE);
//	    af.createTask(task4);
//	    
//	    
//	    Task task5 = new Task("Chair repair",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),40,"dd",TaskType.BUILDING_SERVICE);
//	    af.createTask(task5);
//	    
//	    
//	    Task task6 = new Task("Lawyer Service",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),5000,"dd",TaskType.LEGAL_HELP);
//	    af.createTask(task6);
//	    
//	    
//	    Task task7 = new Task("aaa",DateMaker.dateHelper(1992, 11, 12),DateMaker.dateHelper(2022, 11, 12),1560,"dd",TaskType.COMPUTER_SERVICE);
//	    af.createTask(task7);
//	
//	af.removeTask(task7);
//	    Iterable<Task> getAllTasks = af.getAllTasks();
//	System.out.println(getAllTasks);
	}

}
