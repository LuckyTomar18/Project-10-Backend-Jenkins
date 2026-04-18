package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * CourseDTO represents the Course entity in the system.
 * 
 * It is mapped to the database table "st_course".
 * 
 * This DTO handles:
 * - Course details (name, duration, description)
 * - Unique identification using course name
 * - UI-friendly label and value representation
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_course")
public class CourseDTO extends BaseDTO {

	/**
	 * Name of the course
	 */
	@Column(name = "name", length = 50)
	private String name;

	/**
	 * Duration of the course (e.g., 3 months, 1 year)
	 */
	@Column(name = "duration", length = 50)
	private String duration;

	/**
	 * Description of the course
	 */
	@Column(name = "description", length = 50)
	private String description;

	/**
	 * Gets course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets course name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets course duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Sets course duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Gets course description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets course description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns unique key for the entity (used for validation)
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Returns unique value (course name)
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
		return "Course Name";
	}
	
	/**
	 * Returns table name for generic operations
	 */
	@Override
	public String getTableName() {
		return "Course";
	}

	/**
	 * Returns value for dropdown/display usage
	 */
	@Override
	public String getValue() {
		return name;
	}
}