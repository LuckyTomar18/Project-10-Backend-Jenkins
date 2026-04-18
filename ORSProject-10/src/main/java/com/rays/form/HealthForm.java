package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.HealthDTO;

public class HealthForm extends BaseForm {

	@NotEmpty(message="Health Code is required")
	public String healthCode;

	@NotEmpty(message="Service Name is required")
	public String serviceName;

	@NotEmpty(message="Uptime is required")
	public String uptime;

	@NotEmpty(message="Status is required")
	public String status;

	public String getHealthCode() {
		return healthCode;
	}

	public void setHealthCode(String healthCode) {
		this.healthCode = healthCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		HealthDTO dto = initDTO(new HealthDTO());
		
		dto.setHealthCode(healthCode);
		dto.setServiceName(serviceName);
		dto.setUptime(uptime);
		dto.setStatus(status);
		
		return dto;
	}
}
