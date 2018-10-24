package com.example.demo.entities;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.common.ActionType;
import com.example.demo.common.ComponentType;
import com.example.demo.common.CustomerType;

@Entity (name ="Transaction")
public class Transaction {

	
	@Id
	@Column
	@GeneratedValue
	private long id;
	
	@Column
	private Timestamp timeStamp;
	
	@Enumerated (EnumType.STRING)
	@Column 
	private CustomerType customerType;
	
	@Column
	private String customerDetails;
	
	@Enumerated (EnumType.STRING)
	@Column 
	private ActionType actionType;
	
	@Enumerated (EnumType.STRING)
	@Column 
	private ComponentType componentType;
	
	@Column
	private String componentDetails;
	@Column 
	private boolean success;
	
	@Column 
	private String exception;
	
	
	
	
	public Transaction() {
		
		super();
		
	}




	public Transaction(CustomerType customerType, String customerDetails, ActionType actionType,
			ComponentType componentType, String componentDetails, boolean success, String exception) {
		super();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.customerType = customerType;
		this.customerDetails = customerDetails;
		this.actionType = actionType;
		this.componentType = componentType;
		this.componentDetails = componentDetails;
		this.success = success;
		this.exception = exception;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public Timestamp getTimeStamp() {
		return timeStamp;
	}




	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}




	public CustomerType getCustomerType() {
		return customerType;
	}




	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}




	public String getCustomerDetails() {
		return customerDetails;
	}




	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}




	public ActionType getActionType() {
		return actionType;
	}




	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}




	public ComponentType getComponentType() {
		return componentType;
	}




	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}




	public String getComponentDetails() {
		return componentDetails;
	}




	public void setComponentDetails(String componentDetails) {
		this.componentDetails = componentDetails;
	}




	public boolean isSuccess() {
		return success;
	}




	public void setSuccess(boolean success) {
		this.success = success;
	}




	public String getException() {
		return exception;
	}




	public void setException(String exception) {
		this.exception = exception;
	}




	@Override
	public String toString() {
		return "Transaction [id=" + id + ", timeStamp=" + timeStamp + ", customerType=" + customerType
				+ ", customerDetails=" + customerDetails + ", actionType=" + actionType + ", componentType="
				+ componentType + ", componentDetails=" + componentDetails + ", success=" + success + ", exception="
				+ exception + "]";
	}


	


	


}