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

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	private static final int SRID = 4326;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Booking> getAllBookings(Long customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}

	public List<Vehicle> getCabsWithinLocation(RequestBookingDto requestBookingDto) {
		List<Vehicle> allVehicles = vehicleRepository.findAll();
		List<Vehicle> eligibleVehicles = new ArrayList<>();
		for(Vehicle vehicle : allVehicles) {
			Point pickupFrom = requestBookingDto.getPickupFrom();
			Point dropTo = requestBookingDto.getDropTo();
			pickupFrom.setSRID(SRID);
			dropTo.setSRID(SRID);
			Boolean pickup = vehicleRepository.findWithinServiceArea(requestBookingDto.getPickupFrom(), vehicle.getId());
			Boolean drop = vehicleRepository.findWithinServiceArea(requestBookingDto.getDropTo(), vehicle.getId());
			if(pickup && drop) {
				eligibleVehicles.add(vehicle);
			}
		}
		return eligibleVehicles;
	}
}
