package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_dashboard")
public class DashboardDTO extends BaseDTO {

	@Column(name = "dashboard_code")
	private String dashboardCode;

	@Column(name = "dashboard_name")
	private String dashboardName;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "status")
	private String status;

	public String getDashboardCode() {
		return dashboardCode;
	}

	public void setDashboardCode(String dashboardCode) {
		this.dashboardCode = dashboardCode;
	}

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "dashboardCode";
	}

	@Override
	public String getUniqueValue() {
		return dashboardCode;
	}

	@Override
	public String getLabel() {
		return "dashboardCode";
	}

	@Override
	public String getTableName() {
		return "Dashboard";
	}

}
