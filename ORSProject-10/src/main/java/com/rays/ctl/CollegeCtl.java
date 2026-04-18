package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CollegeDTO;
import com.rays.form.CollegeForm;
import com.rays.service.CollegeServiceInt;

/**
 * CollegeCtl is a REST controller for handling College-related operations.
 * 
 * It extends BaseCtl to inherit common CRUD functionalities
 * such as add, update, delete, search, and get by ID.
 * 
 * This controller delegates business logic to CollegeService.
 * 
 * @author Lucky Tomar
 *
 */
@RestController
@RequestMapping(value = "College")
public class CollegeCtl extends BaseCtl<CollegeForm, CollegeDTO, CollegeServiceInt>{

}