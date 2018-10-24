package com.example.demo.repo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.common.TaskType;
import com.example.demo.entities.Task;



@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

	
	
	  @Transactional
	  	@Modifying
	  	@Query("UPDATE Task task SET task.description = :description , task.startDate = :startDate, task.endDate = :endDate, task.price = :price, task.address = :address WHERE task.id =:id")
	  	public void updatTask(@Param("description") String description , @Param("startDate") Date startDate , @Param("endDate") Date endDate, @Param("price")double price,@Param("address")String address ,@Param("id") long id);
	
	
	

	  @Transactional
		@Modifying
		@Query("DELETE FROM Task task WHERE task.customer.id = :customerId")
		void removeAllCustomersTasks(@Param("customerId") long customerId);

	  
	  
	  
	  
	    Task findById(long id); 
	    
	    
	    
	    @Query("SELECT task FROM Task task WHERE task.startDate>=:startDate AND task.endDate<=:endDate")
		  Iterable<Task>findTaskByDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate); 
	   
	
	
	    
	    @Query("SELECT task FROM Task task WHERE task.price>=:minPrice AND task.price<=:maxPrice")
		  Iterable<Task>findTaskByPrices(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
	    
	    
	    
	    
	    Iterable<Task> findByTaskType(TaskType type);


	    
	    boolean existsByDescription (String description);


}
