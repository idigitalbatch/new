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

import com.example.model.Booking;
import com.example.model.Customer;
import com.example.servises.BookingService;
import com.example.servises.CustomerService;



	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/api/v1")
	public class BookingController {
	    
	    
	    private BookingService bookingService;
	    
	    public BookingController(BookingService bookingService) {
	        super();
	        this.bookingService = bookingService;
	    }



	   
	        
	    //http://localhost:8080/api/v1/addusers
	    @PostMapping("/addbookings")
	    public ResponseEntity<Booking>saveBooking(@Valid @RequestBody Booking booking) {
	        return new ResponseEntity<Booking>(bookingService.saveBooking(booking), HttpStatus.CREATED);
	    }
	    
	    
	    @GetMapping("/getallbookings")
	    public List<Booking> getAllBookings(){
	        return bookingService.getAllBookings();
	    }
	    
	    @GetMapping("/getbooking/{id}")
	    public ResponseEntity<Booking> getBookingById(@PathVariable("id") long bookingId){
	        return new ResponseEntity<Booking>(bookingService.getBookingById(bookingId), HttpStatus.OK);
	        
	    }
	    
	    @PutMapping("/updatebooking/{id}")
	    public ResponseEntity<Booking> updateBooking(@Valid @PathVariable("id")long id ,@RequestBody Booking booking){
	        return new ResponseEntity<Booking>(bookingService.updateBooking(booking, id), HttpStatus.OK);
	        
	    }
//	    @DeleteMapping("/deletebooking/{id}")
//	    public ResponseEntity<String> deleteBooking(@Valid @PathVariable("id") long id){
//	        bookingService.deleteBooking(id);
//	        return new ResponseEntity<String>("Booking deleted successfully!.",HttpStatus.OK);
//	        
//	    }
	    
	    
	    
	    }
