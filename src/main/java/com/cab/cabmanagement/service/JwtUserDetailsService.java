package com.cab.cabmanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cab.cabmanagement.model.Customer;
import com.cab.cabmanagement.repository.CustomerRepository;


/**
 * @author maheshm
 *
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 *This is an overridden method userDetailsService which is responsible to return userdetails object,
	 * which consists the general authentication flags along with user credentials
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Checking requested user is present or not
		Customer customer = customerRepository.findByUsername(username);
		if(customer != null) {
			return new User(customer.getUsername(), customer.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}