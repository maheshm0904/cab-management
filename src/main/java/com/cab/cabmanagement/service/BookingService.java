package com.cab.cabmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.cabmanagement.model.Booking;
import com.cab.cabmanagement.model.RequestBookingDto;
import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.repository.BookingRepository;
import com.cab.cabmanagement.repository.VehicleRepository;
import com.vividsolutions.jts.geom.Point;

/**
 * @author maheshm
 *
 */
@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	private static final int SRID = 4326;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	/**
	 * This service method return all bookings information which is associated with the given customer
	 * @param customerId
	 * @return list of bookings
	 */
	public List<Booking> getAllBookings(Long customerId) {
		//Retrieving bookings for the customerid 
		return bookingRepository.findByCustomerId(customerId);
	}

	/**
	 * This service method is responsible to retrieve all cabs which are serving operations at requested locations 
	 * @param requestBookingDto
	 * @return list of cabs which are eligible to serve at requested pickup and dropping point
	 */
	public List<Vehicle> getCabsWithinLocation(RequestBookingDto requestBookingDto) {
		//Retrieve all available cabs
		List<Vehicle> allVehicles = vehicleRepository.findAll();
		List<Vehicle> eligibleVehicles = new ArrayList<>();
		//Checking service area of every cab to get the right vehicle for requested location
		for(Vehicle vehicle : allVehicles) {
			Point pickupFrom = requestBookingDto.getPickupFrom();
			Point dropTo = requestBookingDto.getDropTo();
			//Setting SRID 4326 to pickup and drop point geometry as to avoid cross origin exception for unknown SRID 0,
			//which is by default attached unless we customize it
			pickupFrom.setSRID(SRID);
			dropTo.setSRID(SRID);
			//Retrieving boolean flags which indicates the pickup or drop point is lies in service area of cab or not
			//To calculate this flag ST_Contains function used
			Boolean pickup = vehicleRepository.findWithinServiceArea(requestBookingDto.getPickupFrom(), vehicle.getId());
			Boolean drop = vehicleRepository.findWithinServiceArea(requestBookingDto.getDropTo(), vehicle.getId());
			if(pickup && drop) {
				//Adding eligible cab to list which will return to user
				eligibleVehicles.add(vehicle);
			}
		}
		return eligibleVehicles;
	}
}
