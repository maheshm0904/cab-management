package com.cab.cabmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.cabmanagement.model.Vehicle;
import com.cab.cabmanagement.service.VehicleService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * @author maheshm
 *
 */
@RestController
public class VehicleController {
	
	private static final int SRID = 4326;
	
	@Autowired
	private VehicleService vehicleService;
	
	/**
	 * This end point will get all nearby cabs
	 * @return list of cabs which are present nearby
	 */
	@GetMapping("/cab-management/cabs")
	public List<Vehicle> getNearByCabs() {
		return vehicleService.getNearByCabs(getPolygon());
		
	}
	
	/**
	 * This method used to create dummy coordinates which will be an linear polygon eg.road etc 
	 * @return Array of coordinates
	 */
	public Coordinate[] getCoordinates() {
		Coordinate[] coordinates = new Coordinate[5];
		coordinates[0] = new Coordinate(1, 2); 
		coordinates[1] = new Coordinate(2, 10);
		coordinates[2] = new Coordinate(10, 55);
		coordinates[3] = new Coordinate(55, 100);
		coordinates[4] = new Coordinate(1, 2);
		return coordinates;	
	}
	
	/**
	 * This method used to get polygon as current location
	 * @return
	 */
	public Polygon getPolygon() {
		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), SRID);
		LinearRing linear = new GeometryFactory().createLinearRing(getCoordinates());
		Polygon poly = new Polygon(linear, null, geometryFactory);
		return poly;
	}

}
