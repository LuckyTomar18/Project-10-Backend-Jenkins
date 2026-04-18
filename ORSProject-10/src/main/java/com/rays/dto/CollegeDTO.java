package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CollegeDTO represents the College entity in the system.
 * 
 * It is mapped to the database table "st_college".
 * 
 * This DTO handles:
 * - College basic details (name, address, state, city, phone number)
 * - Unique identification using college name
 * - Display label and value for UI components
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {

	/**
	 * Name of the college
	 */
	@Column(name = "name", length = 50)
	private String name;

	/**
	 * Address of the college
	 */
	@Column(name = "address", length = 50)
	private String address;

	/**
	 * State of the college
	 */
	@Column(name = "state", length = 50)
	private String state;

	/**
	 * City of the college
	 */
	@Column(name = "city", length = 50)
	private String city;

	/**
	 * Contact phone number
	 */
	@Column(name = "phone_no", length = 15)
	private String phoneNo;

	/**
	 * Gets college name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets college name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets phone number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets phone number
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Returns unique key for the entity (used for validation)
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Returns unique value (college name)
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Returns label for UI display
	 */
	@Override
	public String getLabel() {
		return "College Name";
	}
	
	/**
	 * Returns table name for generic operations
	 */
	@Override
	public String getTableName() {
		return "College";
	}

	/**
	 * Returns value for dropdown/display usage
	 */
	@Override
	public String getValue() {
		return name;
	}
}