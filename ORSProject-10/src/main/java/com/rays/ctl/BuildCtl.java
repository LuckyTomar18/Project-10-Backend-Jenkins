package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.BuildDTO;
import com.rays.form.BuildForm;
import com.rays.service.BuildServiceInt;

@RestController
@RequestMapping(value="Build")
public class BuildCtl extends BaseCtl<BuildForm, BuildDTO, BuildServiceInt> {

}
