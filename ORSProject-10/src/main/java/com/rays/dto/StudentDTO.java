package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * StudentDTO represents the Student entity in the system.
 * 
 * It is mapped to the database table "st_student".
 * 
 * This DTO handles:
 * - Student personal details (enrollment number, name, DOB, contact info)
 * - Association with college
 * - Unique identification using enrollment number
 * - UI-friendly label and value representation
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {

	/**
	 * Enrollment number of the student (unique)
	 */
	@Column(name = "enrol_no", length = 20)
	private String enrolNo;

	/**
	 * First name of the student
	 */
	@Column(name = "first_name", length = 50)
	private String firstName;

	/**
	 * Last name of the student
	 */
	@Column(name = "last_name", length = 50)
	private String lastName;

	/**
	 * Date of birth
	 */
	@Column(name = "dob")
	private Date dob;

	/**
	 * Contact phone number
	 */
	@Column(name = "phone_no", length = 15)
	private String phoneNo;

	/**
	 * Email of the student
	 */
	@Column(name = "email", length = 50)
	private String email;

	/**
	 * College ID reference
	 */
	@Column(name = "college_id")
	private Long collegeId;

	/**
	 * College name (denormalized for quick access)
	 */
	@Column(name = "college_name", length = 50)
	private String collegeName;

	/**
	 * Gets enrollment number
	 */
	public String getEnrolNo() {
		return enrolNo;
	}

	/**
	 * Sets enrollment number
	 */
	public void setEnrolNo(String enrolNo) {
		this.enrolNo = enrolNo;
	}

	/**
	 * Gets first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
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
	 * Gets email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets college ID
	 */
	public Long getCollegeId() {
		return collegeId;
	}

	/**
	 * Sets college ID
	 */
	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * Gets college name
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Sets college name
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Returns unique key (enrollment number)
	 */
	@Override
	public String getUniqueKey() {
		return "enrolNo";
	}

	/**
	 * Returns unique value (enrollment number)
	 */
	@Override
	public String getUniqueValue() {
		return enrolNo;
	}

	/**
	 * Returns label for UI display
	 */
	@Override
	public String getLabel() {
		return "Enroll No";
	}
	
	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "Student";
	}

	/**
	 * Returns value for UI display (full name)
	 */
	@Override
	public String getValue() {
		return firstName + " " + lastName;
	}
}