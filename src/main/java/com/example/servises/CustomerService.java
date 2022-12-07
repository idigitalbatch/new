package com.example.servises;

import java.util.List;

//import com.example.model.Cart;
import com.example.model.Customer;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(long id);
    Customer updateCustomer(Customer customer,long id);


		   


		}
