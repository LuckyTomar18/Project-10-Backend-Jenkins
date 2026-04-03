package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_venue")
public class VenueDTO extends BaseDTO{

	@Column(name="venue_name")
	private String venueName;
	
	@Column(name="city")
	private String city;
	
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
	@Override
	public String getValue() {
		return venueName;
	}
	@Override
	public String getUniqueKey() {
		return "venueName";
	}
	@Override
	public String getUniqueValue() {
		return venueName;
	}
	@Override
	public String getLabel() {
		return "venue_name";
	}
	@Override
	public String getTableName() {
		return "venue";
	}
	
	
	
	
}
