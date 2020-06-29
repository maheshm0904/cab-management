package com.cab.cabmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cab.cabmanagement.model.Vehicle;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
	@Query(value = "SELECT * FROM vehicle WHERE ST_Within(vehicle_current_location, :location) = true" ,nativeQuery=true)
	List<Vehicle> findByVehicleCurrentLocationNear(@Param("location") Polygon location);
	
	List<Vehicle> findAll();
	
	@Query(value = "SELECT ST_Contains(service_area, :location) from vehicle WHERE vehicle_id = :vehicleId" ,nativeQuery=true)
	boolean findWithinServiceArea(@Param("location") Point location, @Param("vehicleId") Long vehicleId);
}
