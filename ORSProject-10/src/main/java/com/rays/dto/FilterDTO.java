package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_filter")
public class FilterDTO extends BaseDTO {

	@Column(name = "filter_code")
	private String filterCode;

	@Column(name = "filter_name")
	private String filterName;

	@Column(name = "value")
	private String value;

	@Column(name = "status")
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
	public String getUniqueKey() {
		return "filterCode";
	}

	@Override
	public String getUniqueValue() {
		return filterCode;
	}

	@Override
	public String getLabel() {
		return "filterCode";
	}

	@Override
	public String getTableName() {
		return "Filter";
	}

}
