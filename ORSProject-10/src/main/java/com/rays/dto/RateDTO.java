package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_rate")
public class RateDTO extends BaseDTO {

	@Column(name="limit_code")
	String rateLimitCode;

	@Column(name="api_name")
	String apiName;

	@Column(name="limit_perMin")
	Integer limitPerMin;

	@Column(name="status")
	String status;

	public String getRateLimitCode() {
		return rateLimitCode;
	}

	public void setRateLimitCode(String rateLimitCode) {
		this.rateLimitCode = rateLimitCode;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Integer getLimitPerMin() {
		return limitPerMin;
	}

	public void setLimitPerMin(Integer limitPerMin) {
		this.limitPerMin = limitPerMin;
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
		return "rateLimitCode";
	}

	@Override
	public String getUniqueValue() {
		return rateLimitCode;
	}

	@Override
	public String getLabel() {
		return "rateLimitCode";
	}

	@Override
	public String getTableName() {
		return "Rate Limit";
	}
	
	
	
}
