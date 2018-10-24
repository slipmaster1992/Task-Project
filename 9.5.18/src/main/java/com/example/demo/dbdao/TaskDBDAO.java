package com.example.demo.dbdao;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.common.TaskType;
import com.example.demo.entities.Task;
import com.example.demo.repo.TaskRepo;



@Component
public class TaskDBDAO implements TaskDAO {

	@Autowired
	TaskRepo taskRepo;

	@Override
	public void createTask(Task task) {
		
		taskRepo.save(task);
	}

	@Override
	public void removeTask(Task task) {
		
		taskRepo.delete(task);
	}

	@Override
	public Iterable<Task> getAllTasks() {
		Iterable<Task> getAllTasks = taskRepo.findAll();
		return getAllTasks;
	}

	

	@Override
	public void updateTask(String description, Date startDate, Date endDate, double price, String address, long id) {
	
		taskRepo.updatTask(description, startDate, endDate, price, address, id);
	}
	
	
    public Task getTaskById(long id) {
    	
    	Task task = taskRepo.findById(id);
    	return task;
    	
    	
    }
	
    
    public Iterable<Task> getAllTasksByDates(Date startDate,Date endDate){
    	
    	Iterable<Task> getTasksByDates = taskRepo.findTaskByDates(startDate, endDate);
		return getTasksByDates;
    	
    	
    }
	
    
    
    public void removeAllCustomerTasks(long customerId) {
    	
    	
    	taskRepo.removeAllCustomersTasks(customerId);
    	
    	
    }
    
    
    
    
    public Iterable<Task> getAllTasksByPrices(double minPrice, double maxPrice){
    	
    	Iterable<Task> getAllTasksByPrices = taskRepo.findTaskByPrices(minPrice, maxPrice);
		return getAllTasksByPrices;
    	
    	
    }
    
    
    
    public Iterable<Task> getAllTasksByType(TaskType type){
    	
    	Iterable<Task> getAllTasksByType = taskRepo.findByTaskType(type);
		return getAllTasksByType;
    	
    	
    }
    
    
    
    public boolean existByDescription(String description) {
    	
    	boolean check = taskRepo.existsByDescription(description);
    	
    	if(check) {
    		
    		return true;
    		
    	} 
    	
    	return false;
    		
     }




}
