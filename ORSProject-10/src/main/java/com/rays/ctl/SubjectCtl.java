package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.SubjectForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * SubjectCtl is a REST controller for handling Subject-related operations.
 * 
 * It extends BaseCtl to inherit common CRUD functionalities.
 * Additionally, it provides a preload API to fetch course data
 * required for subject form dropdowns.
 * 
 * @author Lucky Tomar
 *
 */
@RestController
@RequestMapping(value = "Subject")
public class SubjectCtl extends BaseCtl<SubjectForm, SubjectDTO, SubjectServiceInt> {
	
	@Autowired
	private CourseServiceInt courseService;
	
	
	/**
	 * Preload API to fetch list of courses for subject form dropdown.
	 * 
	 * @return ORSResponse containing course list
	 */
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<DropdownList> list = courseService.search(new CourseDTO(), userContext);
		res.addResult("courseList", list);
		return res;
	}

}