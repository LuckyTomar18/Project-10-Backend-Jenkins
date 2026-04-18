package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * MarksheetDTO represents the Marksheet entity in the system.
 * 
 * It is mapped to the database table "st_marksheet".
 * 
 * This DTO handles:
 * - Student academic records (roll number, name, subject marks)
 * - Association with student via studentId
 * - Unique identification using roll number
 * - UI-friendly labeling
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

	/**
	 * Roll number of the student (unique)
	 */
	@Column(name = "roll_no", length = 20)
	protected String rollNo = null;

	/**
	 * Student ID reference
	 */
	@Column(name = "student_id")
	protected Long studentId;

	/**
	 * Student name
	 */
	@Column(name = "name", length = 50)
	protected String name = null;

	/**
	 * Marks obtained in Physics
	 */
	@Column(name = "physics")
	protected Integer physics;

	/**
	 * Marks obtained in Chemistry
	 */
	@Column(name = "chemistry")
	protected Integer chemistry;

	/**
	 * Marks obtained in Mathematics
	 */
	@Column(name = "maths")
	protected Integer maths;

	/**
	 * Gets roll number
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * Sets roll number
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * Gets student ID
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * Sets student ID
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets student name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets physics marks
	 */
	public Integer getPhysics() {
		return physics;
	}

	/**
	 * Sets physics marks
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	/**
	 * Gets chemistry marks
	 */
	public Integer getChemistry() {
		return chemistry;
	}

	/**
	 * Sets chemistry marks
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * Gets maths marks
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * Sets maths marks
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	
	/**
	 * Returns unique key (roll number)
	 */
	@Override
	public String getUniqueKey() {
		return "rollNo";
	}

	/**
	 * Returns unique value (roll number)
	 */
	@Override
	public String getUniqueValue() {
		return rollNo;
	}

	/**
	 * Returns label for UI display
	 */
	@Override
	public String getLabel() {
		return "Roll No";
	}
	
	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "Marksheet";
	}

	/**
	 * Returns value (not implemented)
	 */
	@Override
	public String getValue() {
		return null;
	}
}