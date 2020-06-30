package com.cab.cabmanagement.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

/**
 * @author maheshm
 * This entity represents the booking table
 */
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
	private Long id;
	private Long customerId;
	private Long vehicleId;
	private Point pickupPoint;
	private Point dropPoint;
	private LocalDateTime bookingDateTime;
	private Boolean isOnGoingRide;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public Point getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(Point pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public Point getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(Point dropPoint) {
		this.dropPoint = dropPoint;
	}
	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}
	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}
	public Boolean getIsOnGoingRide() {
		return isOnGoingRide;
	}
	public void setIsOnGoingRide(Boolean isOnGoingRide) {
		this.isOnGoingRide = isOnGoingRide;
	}

}
