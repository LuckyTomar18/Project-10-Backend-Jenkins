package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base DTO class containing common fields for all entities.
 * It provides audit fields and abstract methods for unique identification.
 * 
 * @author Lucky Tomar
 *
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;

	@Column(name = "created_by", length = 50)
	protected String createdBy = "root";

	@Column(name = "modified_by", length = 50)
	protected String modifiedBy = "root";

	@Column(name = "created_datetime")
	protected Timestamp createdDatetime;

	@Column(name = "modified_datetime")
	protected Timestamp modifiedDatetime;

	/**
	 * Returns unique key (column name).
	 * 
	 * @return unique key
	 */
	public abstract String getUniqueKey();

	/**
	 * Returns unique value for the key.
	 * 
	 * @return unique value
	 */
	public abstract String getUniqueValue();

	/**
	 * Returns label name for the DTO.
	 * 
	 * @return label
	 */
	public abstract String getLabel();
	
	/**
	 * Returns table name of the DTO.
	 * 
	 * @return table name
	 */
	public abstract String getTableName();

	/**
	 * Gets ID.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets ID.
	 * 
	 * @param id primary key
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets created by user.
	 * 
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets created by user.
	 * 
	 * @param createdBy user name
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets modified by user.
	 * 
	 * @return modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets modified by user.
	 * 
	 * @param modifiedBy user name
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets created datetime.
	 * 
	 * @return createdDatetime
	 */
	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * Sets created datetime.
	 * 
	 * @param createdDatetime timestamp
	 */
	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * Gets modified datetime.
	 * 
	 * @return modifiedDatetime
	 */
	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	/**
	 * Sets modified datetime.
	 * 
	 * @param modifiedDatetime timestamp
	 */
	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * Returns key for dropdown (ID as String).
	 * 
	 * @return key
	 */
	public String getKey() {
		return String.valueOf(id);
	}
}