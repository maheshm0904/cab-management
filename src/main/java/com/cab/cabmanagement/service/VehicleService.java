package com.cab.cabmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.repository.VehicleRepository;
import com.vividsolutions.jts.geom.Polygon;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getNearByCabs(Polygon location) {
		return vehicleRepository.findByVehicleCurrentLocationNear(location);
	}

}
