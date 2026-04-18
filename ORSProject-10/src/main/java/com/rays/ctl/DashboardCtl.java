package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.DashboardDTO;
import com.rays.form.DashboardForm;
import com.rays.service.DashboardServiceInt;

@RestController
@RequestMapping(value="Dashboard1")
public class DashboardCtl extends BaseCtl<DashboardForm, DashboardDTO, DashboardServiceInt> {

}
