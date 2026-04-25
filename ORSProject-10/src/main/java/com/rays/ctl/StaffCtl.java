package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.StaffDTO;
import com.rays.form.StaffForm;
import com.rays.service.StaffServiceInt;

@RestController
@RequestMapping(value ="Staff")
public class StaffCtl extends BaseCtl<StaffForm, StaffDTO, StaffServiceInt> {

}
