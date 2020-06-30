package com.cab.cabmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cab.cabmanagement.model.Customer;
/**
 * @author maheshm
 * This repository responsible for all crud operations on customer entity
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	//This repository method will return customer details matching with the given user name
	Customer findByUsername(String username);

}
