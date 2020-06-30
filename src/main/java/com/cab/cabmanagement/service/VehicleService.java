package com.cab.cabmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.repository.VehicleRepository;
import com.vividsolutions.jts.geom.Polygon;

/**
 * @author maheshm
 *
 */
@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	/**
	 * This service method responsible for getting near by cabs
	 * @param location
	 * @return list of cabs
	 */
	public List<Vehicle> getNearByCabs(Polygon location) {
		//Getting vehicles which are present near by given location which is an linear polygon
		//The results are calculated by using ST_Within function
		return vehicleRepository.findByVehicleCurrentLocationNear(location);
	}

}
