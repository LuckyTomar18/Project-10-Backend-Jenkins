package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BuildDTO;

public class BuildForm extends BaseForm {

	@NotEmpty(message = "buildCode is required")
	private String buildCode;

	@NotEmpty(message = "buildVersion is required")
	private String buildVersion;

	@NotEmpty(message = "triggeredBy is required")
	private String triggeredBy;

	@NotEmpty(message = "status is required")
	private String status;

	public String getBuildCode() {
		return buildCode;
	}

	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public String getTriggeredBy() {
		return triggeredBy;
	}

	public void setTriggeredBy(String triggeredBy) {
		this.triggeredBy = triggeredBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		BuildDTO dto = initDTO(new BuildDTO());
		dto.setBuildCode(buildCode);
		dto.setBuildVersion(buildVersion);
		dto.setTriggeredBy(triggeredBy);
		dto.setStatus(status);
		return dto;
	}
}
