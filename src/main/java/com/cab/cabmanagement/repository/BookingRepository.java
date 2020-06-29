package com.cab.cabmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cab.cabmanagement.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{
	
	List<Booking> findByCustomerId(Long customerId);

}
