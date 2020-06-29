package com.cab.cabmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cab.cabmanagement.model.Booking;
import com.cab.cabmanagement.model.RequestBookingDto;
import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/getAllBookings/{customerId}")
	public List<Booking> getAllBookings(@PathVariable Long customerId) {
		return bookingService.getAllBookings(customerId);
		
	}

	@PostMapping("/requestBooking")
	public List<Vehicle> requestBooking(@RequestBody RequestBookingDto requestBookingDto){
		return bookingService.getCabsWithinLocation(requestBookingDto);
	}
	

}
