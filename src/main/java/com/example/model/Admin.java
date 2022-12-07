package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
	@Table(name="admin")
	public class Admin {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    @Column
	    @Size(min = 2, message = "please fill the username ")
	    private String userName;
	    @NotNull
	    @Column
	    @Size(min = 2, message = "please fill the password ")
	    private String password;
	    public Admin() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    public Admin(Long id, String userName, String password) {
	        super();
	        this.id = id;
	        this.userName = userName;
	        this.password = password;
	    }
	    @Override
	    public String toString() {
	        return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	    }
	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
	    public String getUserName() {
	        return userName;
	    }
	    public void setUserName(String userName) {
	        this.userName = userName;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    



	}
