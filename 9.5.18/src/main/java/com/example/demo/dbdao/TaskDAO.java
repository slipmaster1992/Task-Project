package com.example.demo.dbdao;



import java.util.Date;

import com.example.demo.entities.Task;

public interface TaskDAO {

	
	void createTask(Task task);
	
	void  removeTask(Task task);
	
	void updateTask(String description,Date startDate,Date endDate,double price,String address,long id);
	
	Iterable<Task> getAllTasks();
	
	
	
	
}
