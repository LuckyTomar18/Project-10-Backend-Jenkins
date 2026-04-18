package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * UserDTO represents the User entity in the system.
 * 
 * It is mapped to the database table "st_user".
 * 
 * This DTO handles:
 * - User personal details (name, DOB, contact info)
 * - Authentication details (loginId, password)
 * - Authorization (roleId, roleName)
 * - Account status and security tracking
 * 
 * It is used in:
 * - Login/Authentication system
 * - Role-based access control (RBAC)
 * - User profile management
 * 
 * Features:
 * - Tracks last login time
 * - Tracks unsuccessful login attempts
 * - Supports account status (Active, Deactive, Locked)
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_user")
public class UserDTO extends BaseDTO {

	/**
	 * User status constants
	 */
	public static final String ACTIVE = "Active";
	public static final String DEACTIVE = "Deactive";
	public static final String LOCKED = "Locked";

	/**
	 * First name of the user
	 */
	@Column(name = "first_name", length = 50)
	private String firstName;

	/**
	 * Last name of the user
	 */
	@Column(name = "last_name", length = 50)
	private String lastName;

	/**
	 * Login ID (unique username/email)
	 */
	@Column(name = "login_id", length = 50)
	private String loginId;

	/**
	 * User password (should be stored encrypted)
	 */
	@Column(name = "password", length = 50)
	private String password;

	/**
	 * Role ID reference
	 */
	@Column(name = "role_id")
	private Long roleId;

	/**
	 * Role name (denormalized)
	 */
	@Column(name = "role_name", length = 50)
	private String roleName = null;

	/**
	 * Date of birth
	 */
	@Column(name = "dob")
	private Date dob;

	/**
	 * Gender
	 */
	@Column(name = "gender", length = 10)
	private String gender;

	/**
	 * Primary phone number
	 */
	@Column(name = "phone", length = 50)
	private String phone;

	/**
	 * Alternate mobile number
	 */
	@Column(name = "alternate_mobile", length = 50)
	private String alternateMobile;

	/**
	 * Account status (Active, Deactive, Locked)
	 */
	@Column(name = "status", length = 20)
	private String status;

	/**
	 * Last login timestamp
	 */
	@Column(name = "last_login")
	private Timestamp lastLogin;

	/**
	 * Count of unsuccessful login attempts
	 */
	@Column(name = "unsucess_login")
	private Integer unsucessfullLoginAttempt = 0;

	/**
	 * Profile image ID reference
	 */
	@Column(name = "image_id")
	private Long imageId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getUnsucessfullLoginAttempt() {
		return unsucessfullLoginAttempt;
	}

	public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
		this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	/**
	 * Returns full name of the user
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns unique key (loginId)
	 */
	@Override
	public String getUniqueKey() {
		return "loginId";
	}

	/**
	 * Returns unique value (loginId)
	 */
	@Override
	public String getUniqueValue() {
		return loginId;
	}

	/**
	 * Returns label for UI display
	 */
	@Override
	public String getLabel() {
		return "Login Id";
	}
	
	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "User";
	}

	/**
	 * Returns value (not implemented)
	 */
	@Override
	public String getValue() {
		return null;
	}
}