package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * VenueDTO represents the Venue entity in the system.
 * 
 * It is mapped to the database table "st_venue".
 * 
 * This DTO handles:
 * - Venue details (name, city, capacity)
 * - Unique identification using venue name
 * - UI-friendly label and value representation
 * 
 * It is used in:
 * - Event management
 * - Exam center allocation
 * - Scheduling systems
 * 
 * Features:
 * - Stores venue capacity for allocation planning
 * - Helps in filtering venues based on city
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name="st_venue")
public class VenueDTO extends BaseDTO{

	/**
	 * Name of the venue
	 */
	@Column(name="venue_name")
	private String venueName;
	
	/**
	 * City where the venue is located
	 */
	@Column(name="city")
	private String city;
	
	/**
	 * Capacity of the venue (number of people it can hold)
	 */
	@Column(name="capacity")
	private Integer capacity;
	
	
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Returns value for UI display
	 */
	@Override
	public String getValue() {
		return venueName;
	}
	
	/**
	 * Returns unique key (venue name)
	 */
	@Override
	public String getUniqueKey() {
		return "venueName";
	}
	
	/**
	 * Returns unique value (venue name)
	 */
	@Override
	public String getUniqueValue() {
		return venueName;
	}
	
	/**
	 * Returns label for UI display
	 */
	@Override
	public String getLabel() {
		return "venue_name";
	}
	
	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "venue";
	}
}