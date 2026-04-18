package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.FilterDTO;
import com.rays.form.FilterForm;
import com.rays.service.FilterServiceInt;

@RestController
@RequestMapping(value="Filter")
public class FilterCtl extends BaseCtl<FilterForm, FilterDTO, FilterServiceInt> {

}
