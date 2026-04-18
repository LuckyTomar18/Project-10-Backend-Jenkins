package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseServiceInt;

/**
 * CourseCtl is a REST controller for handling Course-related operations.
 * 
 * It extends BaseCtl to inherit common CRUD functionalities
 * such as add, update, delete, search, and get by ID.
 * 
 * This controller delegates business logic to CourseService.
 * 
 * @author Lucky Tomar
 *
 */
@RestController
@RequestMapping(value = "Course")
public class CourseCtl extends BaseCtl<CourseForm, CourseDTO, CourseServiceInt> {

}