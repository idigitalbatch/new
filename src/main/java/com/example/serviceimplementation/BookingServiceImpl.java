package com.example.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Booking;
import com.example.model.Customer;
import com.example.repository.BookingRepository;
import com.example.repository.CustomerRepository;
import com.example.servises.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;
    
    public BookingServiceImpl(BookingRepository bookingRepository) {
        super();
        this.bookingRepository = bookingRepository;
    }

	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
//
//	@Override
//	public User getBookingById(long id) {
//		return bookingRepository.findBookingById(id).orElseThrow(() ->
//        new ResourceNotFoundException("User","Id",id));
//	}

	@Override
	public Booking getBookingById(long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(id).orElseThrow(() ->
		  new ResourceNotFoundException("Booking","Id",id)
				);
	}


	@Override
	public Booking updateBooking(Booking booking, long id) {
		Booking book = bookingRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Booking", "Id", id));
        
       
        book.setCakeType(booking.getCakeType());
        book.setCakeKg(booking.getCakeKg());
        book.setOccassions(booking.getOccassions());
        
        
        bookingRepository.save(book);
        return book;
    }




   

}
