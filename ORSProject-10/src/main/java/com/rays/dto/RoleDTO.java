package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * RoleDTO represents the Role entity in the system.
 * 
 * It is mapped to the database table "st_role".
 * 
 * This DTO handles:
 * - Role details (name, description)
 * - Unique identification using role name
 * - UI-friendly label and value representation
 * 
 * Roles are typically used for:
 * - Authorization
 * - Access control (e.g., Admin, User, Faculty)
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

	/**
	 * Name of the role (e.g., Admin, User)
	 */
	@Column(name = "name", length = 50)
	private String name = null;

	/**
	 * Description of the role
	 */
	@Column(name = "description", length = 100)
	private String description = null;

	/**
	 * Gets role name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets role name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets role description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets role description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns unique key (role name)
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Returns unique value (role name)
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
		return "Role Name";
	}
	
	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "Role";
	}

	/**
	 * Returns value for dropdown/display usage
	 */
	@Override
	public String getValue() {
		return name;
	}
}