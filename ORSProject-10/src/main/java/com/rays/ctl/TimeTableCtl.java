package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;
import com.rays.form.TimeTableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimeTableServiceInt;

/**
 * TimeTableCtl is a REST controller for handling TimeTable-related operations.
 * 
 * It extends BaseCtl to inherit common CRUD functionalities.
 * Additionally, it provides a preload API to fetch course and subject data
 * required for timetable form dropdowns.
 * 
 * @author Lucky Tomar
 *
 */
@RestController
@RequestMapping(value = "TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDTO, TimeTableServiceInt> {
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	/**
	 * Preload API to fetch list of courses and subjects for timetable form.
	 * 
	 * @return ORSResponse containing course and subject lists
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<CourseDTO> list = courseService.search(new CourseDTO(), userContext);
		List<SubjectDTO> list1 = subjectService.search(new SubjectDTO(), userContext);
		res.addResult("courseList", list);
		res.addResult("subjectList", list1);
		return res;
	}
}