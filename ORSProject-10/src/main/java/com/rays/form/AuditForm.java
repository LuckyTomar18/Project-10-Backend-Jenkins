package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AuditDTO;

public class AuditForm extends BaseForm{

	@NotEmpty(message="Audit code is required")
	private String auditCode ;

	@NotEmpty(message="action is required")
	private String action ;

	@NotEmpty(message="performedBy is required")
	private String performedBy ;

	@NotEmpty(message="status is required")
	private String status ;

	public String getAuditCode() {
		return auditCode;
	}

	public void setAuditCode(String auditCode) {
		this.auditCode = auditCode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public BaseDTO getDto() {
		AuditDTO dto = initDTO(new AuditDTO());
		dto.setAuditCode(auditCode);
		dto.setAction(action);
		dto.setPerformedBy(performedBy);
		dto.setStatus(status);
		return dto;
	}
}
