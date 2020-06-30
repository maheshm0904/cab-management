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

/**
 * @author maheshm
 *
 */
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	/**
	 * This end point used to get all bookings related to customer
	 * @param customerId
	 * @return list of bookings
	 */
	@GetMapping("/cab-management/bookings/{customerId}")
	public List<Booking> getAllBookings(@PathVariable Long customerId) {
		return bookingService.getAllBookings(customerId);
		
	}

	/**
	 * This end point used to request booking between pickup and drop locations
	 * @param requestBookingDto
	 * @return list of cabs which are available for that location
	 */
	@PostMapping("/cab-management/bookings")
	public List<Vehicle> requestBooking(@RequestBody RequestBookingDto requestBookingDto){
		return bookingService.getCabsWithinLocation(requestBookingDto);
	}
	

}
