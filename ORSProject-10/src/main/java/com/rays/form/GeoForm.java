package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.GeoDTO;

public class GeoForm extends BaseForm {

	@NotEmpty(message="geoFenceCode is required")
	private String geoFenceCode;

	@NotEmpty(message="locationName is required")
	private String locationName;

	@NotEmpty(message="radius is required")
	private String radius;

	@NotEmpty(message="status is required")
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
	public BaseDTO getDto() {
		GeoDTO dto = initDTO(new GeoDTO());
		dto.setGeoFenceCode(geoFenceCode);
		dto.setLocationName(locationName);
		dto.setRadius(radius);
		dto.setStatus(status);
		return dto;
	}
}
