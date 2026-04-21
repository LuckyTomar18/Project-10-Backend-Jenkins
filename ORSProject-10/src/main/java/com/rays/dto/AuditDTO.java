package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_audit")
public class AuditDTO extends BaseDTO{


	@Column(name="audit_code")
	private String auditCode ;

	@Column(name="action")
	private String action ;

	@Column(name="performed_by")
	private String performedBy ;

	@Column(name="status")
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
	public String getValue() {
		return null;
	}

	@Override
	public String getUniqueKey() {
		return "auditCode";
	}

	@Override
	public String getUniqueValue() {
		return auditCode;
	}

	@Override
	public String getLabel() {
		return "auditCode";
	}

	@Override
	public String getTableName() {
		return "Audit";
	}
	
	
	
}
