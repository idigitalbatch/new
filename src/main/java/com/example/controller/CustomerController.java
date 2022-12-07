package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.model.Cart;
import com.example.model.Customer;
import com.example.servises.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    
    
    private CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }



   
        
    //http://localhost:8080/api/v1/addcustomers
    @PostMapping("/addcustomers")
    public ResponseEntity<Customer>saveCustomer(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }
    
    
    @GetMapping("/getallcustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/getcustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId){
        return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
        
    }
    
    @PutMapping("/updatecustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable("id")long id ,@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
        
    }
    
//    @DeleteMapping("/deletecustomer/{id}")
//    public ResponseEntity<String> deleteCustomer(@Valid @PathVariable("id") long id){
//        customerService.deleteCustomer(id);
//        return new ResponseEntity<String>("Customer deleted successfully!.",HttpStatus.OK);
//        
//    }
//    
    
    
    }     
    
