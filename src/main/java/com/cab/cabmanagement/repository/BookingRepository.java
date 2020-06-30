package com.cab.cabmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cab.cabmanagement.model.Booking;

/**
 * This repository responsible for all crud operations on booking entity
 * @author maheshm
 *
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
	//This service method responsible for returning list of all bookings associated with given customer id
	List<Booking> findByCustomerId(Long customerId);
}
