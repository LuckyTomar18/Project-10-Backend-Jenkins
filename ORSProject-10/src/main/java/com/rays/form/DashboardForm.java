package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DashboardDTO;

public class DashboardForm extends BaseForm {

	@NotEmpty(message = "code is required")
	private String dashboardCode;

	@NotEmpty(message = "dashboardName is required")
	private String dashboardName;

	@NotEmpty(message = "userName is required")
	private String userName;

	@NotEmpty(message = "status is required")
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
	public BaseDTO getDto() {
		DashboardDTO dto = initDTO(new DashboardDTO());
		dto.setDashboardCode(dashboardCode);
		dto.setDashboardName(dashboardName);
		dto.setStatus(status);
		dto.setUserName(userName);

		return dto;
	}
}
