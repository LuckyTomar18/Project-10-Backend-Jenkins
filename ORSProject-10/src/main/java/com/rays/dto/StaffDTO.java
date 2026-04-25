package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_staff")
public class StaffDTO extends BaseDTO {
	
	@Column(name = "employee_code")
	private String employeeCode;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "division")
	private String division;
	
	@Column(name = "previous_employer")
	private String previousEmployer;
	
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getPreviousEmployer() {
		return previousEmployer;
	}

	public void setPreviousEmployer(String previousEmployer) {
		this.previousEmployer = previousEmployer;
	}
	
	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String getUniqueKey() {
		return "employeeCode";
	}

	@Override
	public String getUniqueValue() {
		return employeeCode;
	}

	@Override
	public String getLabel() {
		return "employeeCode";
	}

	@Override
	public String getTableName() {
		return "Staff";
	}

}
