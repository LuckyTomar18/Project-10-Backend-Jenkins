package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_division")
public class DivisionDTO extends BaseDTO {

	@Column(name="division")
	private String division;
	
	
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
	@Override
	public String getValue() {
		return division;
	}

	@Override
	public String getUniqueKey() {
		return "division";
	}

	@Override
	public String getUniqueValue() {
		return division;
	}

	@Override
	public String getLabel() {
		return "division";
	}

	@Override
	public String getTableName() {
		return "Division";
	}

}
