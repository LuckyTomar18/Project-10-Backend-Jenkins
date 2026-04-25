package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DivisionDTO;

public class DivisionForm extends BaseForm{

	
	public static final int IT = 1;
	public static final int HR = 2;
	public static final int MARKETING = 3;
	public static final int FINANCE = 4;
	
	
	@NotEmpty(message="division is required")
	private String division;

	
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
	@Override
	public BaseDTO getDto() {
		DivisionDTO dto = initDTO(new DivisionDTO());
		dto.setDivision(division);
		return dto;
	}
}
