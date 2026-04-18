package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ReportDTO;
import com.rays.form.ReportForm;
import com.rays.service.ReportServiceInt;

@RestController
@RequestMapping(value="Report")
public class ReportCtl extends BaseCtl<ReportForm, ReportDTO, ReportServiceInt>{

}
