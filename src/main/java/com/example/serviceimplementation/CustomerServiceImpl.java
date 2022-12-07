package com.example.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.DuplicateEntryException;
import com.example.exception.ResourceNotFoundException;
//import com.example.model.Cart;
import com.example.model.Customer;
//import com.example.repository.CartRepository;
import com.example.repository.CustomerRepository;
import com.example.servises.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	    
		private CustomerRepository customerRepository;
		    
		    public CustomerServiceImpl(CustomerRepository customerRepository) {
		        super();
		        this.customerRepository = customerRepository;
		    }

			@Override
			public Customer saveCustomer(Customer customer) {
				return customerRepository.save(customer);
			}

			@Override
			public List<Customer> getAllCustomers() {
				return customerRepository.findAll();
			}

			@Override
			public Customer getCustomerById(long id) {
				// TODO Auto-generated method stub
				return customerRepository.findById(id).orElseThrow(() ->
				  new ResourceNotFoundException("Customer","Id",id)
						);
			}


			@Override
			public Customer updateCustomer(Customer customer, long id) {
				Customer user = customerRepository.findById(id).orElseThrow(
		                ()-> new ResourceNotFoundException("Customer", "Id", id));
				user.setFirstName(user.getFirstName());
				user.setLastName(user.getLastName());
		        user.setEmailId(user.getEmailId());
		        user.setPhoneNo(user.getPhoneNo());
		        user.setPassword(user.getPassword());
		        
		        customerRepository.save(user);
		        return user;
		    }




		   

		}