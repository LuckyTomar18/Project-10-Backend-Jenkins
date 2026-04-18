package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RateDTO;

public class RateForm extends BaseForm{

	@NotEmpty(message="Limit is required")
	String rateLimitCode;

	@NotEmpty(message="apiName is required")
	String apiName;

	@NotNull(message="limitPerMin is required")
	Integer limitPerMin;

	@NotEmpty(message="status is required")
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
	public BaseDTO getDto() {
		RateDTO dto = initDTO(new RateDTO());
		dto.setRateLimitCode(rateLimitCode);
		dto.setApiName(apiName);
		dto.setLimitPerMin(limitPerMin);
		dto.setStatus(status);
		return dto;
	}
}
