package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.HealthDTO;
import com.rays.form.HealthForm;
import com.rays.service.HealthServiceInt;

@RestController
@RequestMapping(value="Health")
public class HealthCtl extends BaseCtl<HealthForm, HealthDTO, HealthServiceInt> {

}
