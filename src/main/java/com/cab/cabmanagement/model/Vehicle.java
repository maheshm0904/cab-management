package com.cab.cabmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * @author maheshm
 * This entity represents the vehicle table
 */
@Entity
@Table(name="vehicle")
public class Vehicle extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
	private Long id;
	private String vehicleType;
	private String vehicleNumber;
	private Point vehicleCurrentLocation;
	private Polygon serviceArea;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Point getVehicleCurrentLocation() {
		return vehicleCurrentLocation;
	}
	public void setVehicleCurrentLocation(Point vehicleCurrentLocation) {
		this.vehicleCurrentLocation = vehicleCurrentLocation;
	}
	public Polygon getServiceArea() {
		return serviceArea;
	}
	public void setServiceArea(Polygon serviceArea) {
		this.serviceArea = serviceArea;
	}
}
