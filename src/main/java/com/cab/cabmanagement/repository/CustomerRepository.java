package com.cab.cabmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cab.cabmanagement.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findByUsername(String username);

}
