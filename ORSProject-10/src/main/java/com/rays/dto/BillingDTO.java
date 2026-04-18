package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_billing")
public class BillingDTO extends BaseDTO {

	@Column(name="billing_code")
	public String billingCode ;

	@Column(name="user_name")
	public String userName ;

	@Column(name="amount")
	public Double amount ;

	@Column(name="status")
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
	public String getValue() {
		return null;
	}

	@Override
	public String getUniqueKey() {
		return "userName";
	}

	@Override
	public String getUniqueValue() {
		return userName;
	}

	@Override
	public String getLabel() {
		return "userName";
	}

	@Override
	public String getTableName() {
		return "Billing";
	}
	
	
	
}
