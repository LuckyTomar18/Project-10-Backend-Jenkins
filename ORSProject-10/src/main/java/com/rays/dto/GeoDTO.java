package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_geo")
public class GeoDTO extends BaseDTO{

	@Column(name="geo_fence_Code")
	private String geoFenceCode;

	@Column(name="location_name")
	private String locationName;

	@Column(name="radius")
	private String radius;

	@Column(name="status")
	private String status;

	public String getGeoFenceCode() {
		return geoFenceCode;
	}

	public void setGeoFenceCode(String geoFenceCode) {
		this.geoFenceCode = geoFenceCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String getUniqueKey() {
		return "geoFenceCode";
	}

	@Override
	public String getUniqueValue() {
		return geoFenceCode;
	}

	@Override
	public String getLabel() {
		return "geoFenceCode";
	}

	@Override
	public String getTableName() {
		return "Geo";
	}
	
	
	
}
