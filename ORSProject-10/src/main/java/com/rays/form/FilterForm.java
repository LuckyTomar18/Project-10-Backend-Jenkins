package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FilterDTO;


public class FilterForm extends BaseForm{

	@NotEmpty(message ="filterCode is required")
	private String filterCode;

	@NotEmpty(message ="filterName is required")
	private String filterName;

	@NotEmpty(message ="value is required")
	private String value;

	@NotEmpty(message ="status is required")
	private String status;

	public String getFilterCode() {
		return filterCode;
	}

	public void setFilterCode(String filterCode) {
		this.filterCode = filterCode;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDto() {
          FilterDTO dto = initDTO(new FilterDTO());
          dto.setFilterCode(filterCode);
          dto.setFilterName(filterName);
          dto.setValue(value);
          dto.setStatus(status);
          
		return dto;
	}

}
