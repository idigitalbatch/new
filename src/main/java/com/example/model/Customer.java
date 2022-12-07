package com.example.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
      
    @NotNull
    @Size(min = 2, message = "please fill the first name ")
    private String firstName;
    @NotNull
    @Size(min = 2, message = "please fill the last name ")
    private String lastName;
    @NotNull
    @Size(min = 2, message = "please fill the password ")
    private String password;
    @NotBlank
    @Email
    private String emailId;
    @NotNull
    private long phoneNo;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(long id, @NotNull @Size(min = 2, message = "please fill the first name ") String firstName,
			@NotNull @Size(min = 2, message = "please fill the last name ") String lastName,
			@NotNull @Size(min = 2, message = "please fill the password ") String password,
			@NotBlank @Email String emailId, @NotNull long phoneNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
    
    
    
    
}


	