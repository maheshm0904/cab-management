package com.cab.cabmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.vividsolutions.jts.geom.Point;

/**
 * @author maheshm
 *
 */
@Entity
@Table(name = "Customer")
public class Customer extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
	private Long id;
	private String customerName;
	private String username;
	private String password;
	private Point currLocation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Point getCurrLocation() {
		return currLocation;
	}
	public void setCurrLocation(Point currLocation) {
		this.currLocation = currLocation;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
