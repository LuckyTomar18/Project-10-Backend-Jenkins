package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * SubjectDTO represents the Subject entity in the system.
 * 
 * It is mapped to the database table "st_subject".
 * 
 * This DTO handles:
 * - Subject details (name, description)
 * - Association with a course (courseId, courseName)
 * - Unique identification using subject name
 * - UI-friendly label and value representation
 * 
 * Subjects belong to a Course and are used in:
 * - Academic structure
 * - Marksheet mapping
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_subject")
public class SubjectDTO extends BaseDTO {

	/**
	 * ID of the associated course
	 */
	@Column(name = "course_id", length = 50)
	private long courseId;

	/**
	 * Name of the associated course (denormalized)
	 */
	@Column(name = "course_name", length = 50)
	private String courseName;

	/**
	 * Name of the subject
	 */
	@Column(name = "name", length = 50)
	private String name;

	/**
	 * Description of the subject
	 */
	@Column(name = "description", length = 50)
	private String description;

	/**
	 * Gets course ID
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * Sets course ID
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets subject name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets subject name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets subject description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets subject description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns unique key (subject name)
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Returns unique value (subject name)
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
		return "Subject Name";
	}
	
	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "Subject";
	}

	/**
	 * Returns value for dropdown/display usage
	 */
	@Override
	public String getValue() {
		return name;
	}
}