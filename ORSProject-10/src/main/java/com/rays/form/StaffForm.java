package com.rays.form;

import java.util.Date;

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

	@NotEmpty(message = "Division Code is required")
	private String division;

	@NotEmpty(message = "PreviousEmployer Code is required")
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
	public BaseDTO getDto() {
		StaffDTO dto = initDTO(new StaffDTO());
		dto.setFullName(fullName);
		dto.setEmployeeCode(employeeCode);
		dto.setDivision(division);
		dto.setJoiningDate(joiningDate);
		dto.setPreviousEmployer(previousEmployer);

		return dto;
	}

}
