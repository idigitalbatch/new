package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Payment;
import com.example.servises.PaymentService;

@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/v1")
	public class PaymentController {
	    
	    
	private PaymentService paymentService;
	    
	    public PaymentController(PaymentService paymentService) {
	        super();
	        this.paymentService = paymentService;
	    }



	   
	        
	    //http://localhost:8080/api/v1/addcustomers
	    @PostMapping("/addpayments")
	    public ResponseEntity<Payment>savePayment(@Valid @RequestBody Payment payment) {
	        return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
	    }
	    
	    
	    @GetMapping("/getallpayments")
	    public List<Payment> getAllPayments(){
	        return paymentService.getAllPayments();
	    }
	    
	    @GetMapping("/getpayment/{id}")
	    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") long paymentId){
	        return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
	        
	    }
	    
	    @PutMapping("/updatepayment/{id}")
	    public ResponseEntity<Payment> updatePayment(@Valid @PathVariable("id")long id ,@RequestBody Payment payment){
	        return new ResponseEntity<Payment>(paymentService.updatePayment(payment, id), HttpStatus.OK);
	        
	    }
	    @DeleteMapping("/deletepayment/{id}")
	    public ResponseEntity<String> deletePayment(@Valid @PathVariable("id") long id){
	        paymentService.deletePayment(id);
	        return new ResponseEntity<String>("Payment deleted successfully!.",HttpStatus.OK);
	        
	    }
	    }
