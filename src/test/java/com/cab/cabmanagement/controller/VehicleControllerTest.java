package com.cab.cabmanagement.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cab.cabmanagement.model.Booking;
import com.cab.cabmanagement.model.Customer;
import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.repository.BookingRepository;
import com.cab.cabmanagement.repository.CustomerRepository;
import com.cab.cabmanagement.repository.VehicleRepository;
import com.cab.cabmanagement.service.BookingService;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@EnableJpaRepositories(basePackages = "com.cab.cabmanagement.repository")
@PropertySource("classpath:test.properties")
public class VehicleControllerTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	
	@InjectMocks
	private BookingService bookingService;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleController vehicleController;
	
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setUsername("maheshm");
		customer.setPassword("Password");
		customer.setCustomerName("mahesh");
		customerRepository.save(customer);
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1L);
		vehicle.setServiceArea(vehicleController.getPolygon());
		vehicleRepository.save(vehicle);
		Booking booking = new Booking();
		booking.setId(1L);
		booking.setCustomerId(customer.getId());
		booking.setVehicleId(vehicle.getId());
		bookingRepository.save(booking);
	}
		
	
	@Test
	public void testGetNearByCabs() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/cab-management/cabs"))
        .andExpect(status().isOk());
	}

}
