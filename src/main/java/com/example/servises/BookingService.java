package com.example.servises;

import java.util.List;

import com.example.model.Booking;
import com.example.model.Customer;

public interface BookingService {
	
	
	Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(long id);
    Booking updateBooking(Booking booking,long id);

}
