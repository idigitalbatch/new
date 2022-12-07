package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
	@Table(name="payment")
	public class Payment {



	           @Id
	            @GeneratedValue(strategy = GenerationType.IDENTITY)
	            private long id;
	            @NotNull
	            @Column
	            @Size(min = 2, message = "please fill the name ")
	            private String name;
	            @NotNull
	            @Column
	            @Size(min = 2, message = "please fill the bankname ")
	            private String bankName;
	            @NotNull
	            @Column
	            private String accNo;
	            @NotNull
	            @Column
	            private String ifscCode;
	            @NotNull
	            @Column
	            private String amount;
	            
	            
	            @OneToOne(targetEntity=Customer.class)  
	            private Customer customer;  
	            
	            public Payment() {
	                super();
	                
	            }
	            public Payment(Customer customer) {
	                super();
	                this.customer = customer;
	            }
	            public Customer getCustomer() {
	                return customer;
	            }
	            public void setCustomer(Customer customer) {
	                this.customer = customer;
	            }
	            public Payment(long id, String name, String bankName, String accNo, String ifscCode, String amount) {
	                super();
	                this.id = id;
	                this.name = name;
	                this.bankName = bankName;
	                this.accNo = accNo;
	                this.ifscCode = ifscCode;
	                this.amount = amount;
	            }
	            @Override
	            public String toString() {
	                return "Payment [id=" + id + ", name=" + name + ", bankName=" + bankName + ", accNo=" + accNo
	                        + ", ifscCode=" + ifscCode + ", amount=" + amount + "]";
	            }
	            public long getId() {
	                return id;
	            }
	            public void setId(long id) {
	                this.id = id;
	            }
	            public String getName() {
	                return name;
	            }
	            public void setName(String name) {
	                this.name = name;
	            }
	            public String getBankName() {
	                return bankName;
	            }
	            public void setBankName(String bankName) {
	                this.bankName = bankName;
	            }
	            public String getAccNo() {
	                return accNo;
	            }
	            public void setAccNo(String accNo) {
	                this.accNo = accNo;
	            }
	            public String getIfscCode() {
	                return ifscCode;
	            }
	            public void setIfscCode(String ifscCode) {
	                this.ifscCode = ifscCode;
	            }
	            public String getAmount() {
	                return amount;
	            }
	            public void setAmount(String amount) {
	                this.amount = amount;
	            }
	            
	            
	            
	            
	}
