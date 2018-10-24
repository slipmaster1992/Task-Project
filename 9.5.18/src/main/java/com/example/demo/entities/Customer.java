package com.example.demo.entities;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.common.Gender;
@XmlRootElement
@Entity(name = "Customer")
public class Customer implements Serializable {

	
	@Id
	@Column
	@GeneratedValue
	private long id;
	
	@Column
	private String custName;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	

	
	public Customer() {
		
		super();
		
	}

	
	


	public Customer(long id, String custName, String password, String email, String address, Gender gender) {
		super();
		this.id = id;
		this.custName = custName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.gender = gender;
	}





	public Customer(String custName, String password, String email, String address, Gender gender) {
		super();
		this.custName = custName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.gender = gender;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCustName() {
		return custName;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}


	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", gender=" + gender + "]";
	}
	
	
	
	
	
	
	
}
