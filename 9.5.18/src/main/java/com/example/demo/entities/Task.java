package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.common.TaskType;

@XmlRootElement
@Entity(name = "Task")
public class Task implements Serializable {

	@Id
	@Column
	@GeneratedValue
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	@Column
	private Date startDate;
	
	@Column
	private Date endDate;
	
	@Column
	private double price;
	
	@Column
	private String address;
	 
	@Column
	@Enumerated(EnumType.STRING)
	private TaskType taskType;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id" , nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;
	
	
	
	
	
	public Task() {
		
		super();
		
		
	}





	public Task(String title, String description, Date startDate, Date endDate, double price, String address,
			TaskType taskType) {
		super();
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.address = address;
		this.taskType = taskType;
	}





	public Task(long id, String title, String description, Date startDate, Date endDate, double price, String address,
			TaskType taskType) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.address = address;
		this.taskType = taskType;
	}




	

	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Date getStartDate() {
		return startDate;
	}





	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public Date getEndDate() {
		return endDate;
	}





	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}





	public double getPrice() {
		return price;
	}





	public void setPrice(double price) {
		this.price = price;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public TaskType getTaskType() {
		return taskType;
	}





	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}





	public Customer getCustomer() {
		return customer;
	}





	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	


	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", price=" + price + ", address=" + address + ", taskType=" + taskType
				+ ", customer=" + customer + "]";
	}

	


	
	
	
	

}
