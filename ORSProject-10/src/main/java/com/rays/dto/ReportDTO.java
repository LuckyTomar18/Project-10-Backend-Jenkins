package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_report")
public class ReportDTO extends BaseDTO {

	@Column(name = "report_type")
	private String reportType;
	
	@Column(name = "generated_date")
	private Date generatedDate;
	
	@Column(name = "remarks")
	private String remarks;
	
	
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String getUniqueKey() {
		return null;
	}

	@Override
	public String getUniqueValue() {
		return null;
	}

	@Override
	public String getLabel() {
		return "remarks";
	}

	@Override
	public String getTableName() {
		return "Report";
	}

}
