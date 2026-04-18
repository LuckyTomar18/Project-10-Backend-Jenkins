package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;
@Entity
@Table(name = "st_parking")
public class ParkingDTO extends BaseDTO {

	@Column(name = "location")
	private String location;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "fee")
	private Double fee;
	
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUniqueKey() {
		
		return "";
	}
	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return "";	
	}
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "location";
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Parking";
	}
}
