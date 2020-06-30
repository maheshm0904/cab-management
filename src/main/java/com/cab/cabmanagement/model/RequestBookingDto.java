package com.cab.cabmanagement.model;

import com.vividsolutions.jts.geom.Point;

/**
 * @author maheshm
 * This dto will used to map booking request payload
 */
public class RequestBookingDto {
	
	private Point pickupFrom;
	private Point dropTo;
	public Point getPickupFrom() {
		return pickupFrom;
	}
	public void setPickupFrom(Point pickupFrom) {
		this.pickupFrom = pickupFrom;
	}
	public Point getDropTo() {
		return dropTo;
	}
	public void setDropTo(Point dropTo) {
		this.dropTo = dropTo;
	}
}
