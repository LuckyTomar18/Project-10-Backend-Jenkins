package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VenueDTO;

/**
 * Form for Venue entity.
 * Handles validation and converts data to VenueDTO.
 * 
 * @author Lucky Tomar
 */
public class VenueForm extends BaseForm {

	@NotEmpty(message="venue name is required")
	private String venueName;
	
	@NotEmpty(message="city is required")
	private String city;
	
	@NotNull(message="capacity is requuired")
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
	public BaseDTO getDto() {
		VenueDTO dto = initDTO(new VenueDTO());
		dto.setVenueName(venueName);
		dto.setCity(city);
		dto.setCapacity(capacity);
		return dto ;
	}
}