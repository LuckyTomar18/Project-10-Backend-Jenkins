package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * TimeTableDTO represents the TimeTable entity in the system.
 * 
 * It is mapped to the database table "st_timetable".
 * 
 * This DTO handles:
 * - Exam scheduling details (date, time, semester)
 * - Association with course and subject
 * - Description for additional information
 * 
 * It is used in:
 * - Exam planning
 * - Scheduling system
 * - Academic timetable management
 * 
 * Note:
 * - Course and Subject names are denormalized for faster access
 * 
 * @author Lucky Tomar
 *
 */
@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

	/**
	 * Course ID reference
	 */
	@Column(name = "course_id", length = 50)
	private long courseId;

	/**
	 * Course name (denormalized)
	 */
	@Column(name = "course_name", length = 50)
	private String courseName;

	/**
	 * Subject ID reference
	 */
	@Column(name = "subject_id", length = 50)
	private long subjectId;

	/**
	 * Subject name (denormalized)
	 */
	@Column(name = "subject_name", length = 50)
	private String subjectName;

	/**
	 * Exam date
	 */
	@Column(name = "exam_date")
	private Date examDate;

	/**
	 * Exam time (e.g., 10:00 AM - 1:00 PM)
	 */
	@Column(name = "exam_time", length = 50)
	private String examTime;

	/**
	 * Semester (e.g., 1st, 2nd, Final)
	 */
	@Column(name = "semester", length = 30)
	private String semester;

	/**
	 * Additional description
	 */
	@Column(name = "description", length = 50)
	private String description;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns unique key (currently courseName)
	 */
	@Override
	public String getUniqueKey() {
		return "courseName";
	}

	/**
	 * Returns unique value (courseName)
	 */
	@Override
	public String getUniqueValue() {
		return courseName;
	}

	/**
	 * Returns label (not implemented)
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Returns table name
	 */
	@Override
	public String getTableName() {
		return "TimeTable";
	}

	/**
	 * Returns value (not implemented)
	 */
	@Override
	public String getValue() {
		return null;
	}
}