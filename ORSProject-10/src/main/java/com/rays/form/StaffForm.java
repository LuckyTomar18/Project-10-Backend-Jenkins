package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StaffDTO;

public class StaffForm extends BaseForm {

	@NotEmpty(message = "Employee Code is required")
	@Pattern(regexp = "^#[A-Za-z0-9]{3,10}$", message = "Employee Code must start with '#' and contain 3 to 10 alphanumeric characters")
	private String employeeCode;

	@NotEmpty(message = "Full Name is required")
	@Pattern(regexp = "^[A-Za-z]{2,}(?: [A-Za-z]{2,})+$", message = "Full Name must contain at least two words and only alphabets")
	private String fullName;

	@NotNull(message = "Joining Date is required")
	@PastOrPresent(message = "Joining Date cannot be in the future")
	private Date joiningDate;

	private String divisionName = null;
	
	
	@NotNull(message = "Division is required")
	@Min(1)
	private Long divisionId;


	@NotEmpty(message = "PreviousEmployer Code is required")
	private String previousEmployer;

	
	public String getEmployeeCode() {
		return employeeCode;
	}


	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}


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


	public String getDivisionName() {
		return divisionName;
	}


	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}


	public Long getDivisionId() {
		return divisionId;
	}


	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}


	public String getPreviousEmployer() {
		return previousEmployer;
	}


	public void setPreviousEmployer(String previousEmployer) {
		this.previousEmployer = previousEmployer;
	}


	@Override
	public BaseDTO getDto() {
		StaffDTO dto = initDTO(new StaffDTO());
		dto.setFullName(fullName);
		dto.setEmployeeCode(employeeCode);
		dto.setDivisionId(divisionId);
		dto.setDivisionName(divisionName);
		dto.setJoiningDate(joiningDate);
		dto.setPreviousEmployer(previousEmployer);

		return dto;
	}

}
