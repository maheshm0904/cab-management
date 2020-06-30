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

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.cab.cabmanagement.model.Booking;
import com.cab.cabmanagement.model.Customer;
import com.cab.cabmanagement.model.RequestBookingDto;
import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.repository.BookingRepository;
import com.cab.cabmanagement.repository.CustomerRepository;
import com.cab.cabmanagement.repository.VehicleRepository;
import com.cab.cabmanagement.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@EnableJpaRepositories(basePackages = "com.cab.cabmanagement.repository")
@PropertySource("classpath:test.properties")
public class BookingControllerTest {
	
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
	
	private Long customerId;
	
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
		customerId = customer.getId();
	}
		
	
	@Test
	public void testGetAllBookings() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/cab-management/bookings/"+customerId))
        .andExpect(status().isOk());
	}
	
	@Test
	public void testRequestBooking() throws Exception {
		RequestBookingDto requestBookingDto = new RequestBookingDto();
		GeometryFactory gf = new GeometryFactory();
	    Point pickupFrom = gf.createPoint(new Coordinate(10.809003,52.097834));
	    Point dropTo = gf.createPoint(new Coordinate(10.809003,52.097834));
		requestBookingDto.setPickupFrom(pickupFrom);
		requestBookingDto.setDropTo(dropTo);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JtsModule());
		this.mockMvc.perform(MockMvcRequestBuilders.post("/cab-management/bookings")
				.contentType("application/json")
				.content(mapper.writeValueAsString(requestBookingDto)))
        .andExpect(status().isOk());
		
	}

}
