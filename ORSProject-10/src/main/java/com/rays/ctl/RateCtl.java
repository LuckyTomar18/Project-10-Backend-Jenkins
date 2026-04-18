package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.RateDTO;
import com.rays.form.RateForm;
import com.rays.service.RateServiceInt;

@RestController
@RequestMapping(value="Rate")
public class RateCtl extends BaseCtl<RateForm, RateDTO, RateServiceInt> {

}
