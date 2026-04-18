package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_health")
public class HealthDTO extends BaseDTO {

	@Column(name="health_code")
	public String healthCode;

	@Column(name="service_name")
	public String serviceName;

	@Column(name="uptime")
	public String uptime;

	@Column(name="status")
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
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueKey() {
		return "healthCode";
	}

	@Override
	public String getUniqueValue() {
		return healthCode;
	}

	@Override
	public String getLabel() {
		return "healthCode";
	}

	@Override
	public String getTableName() {
		return "Health";
	}

}
