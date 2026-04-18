package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BillingDTO;

public class BillingForm extends BaseForm {

	@NotEmpty(message="billing code is required")
	public String billingCode ;

	@NotEmpty(message="userName is required")
	public String userName ;

	@NotNull(message="Amount is required")
	public Double amount ;

	@NotEmpty(message="status is required")
	public String status ;

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDto() {
		
		BillingDTO dto = initDTO(new BillingDTO());
		dto.setBillingCode(billingCode);
		dto.setUserName(userName);
		dto.setAmount(amount);
		dto.setStatus(status);
		
		return dto;
	}
}
