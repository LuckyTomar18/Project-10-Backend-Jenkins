package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.DiseaseDTO;
import com.rays.form.DiseaseForm;
import com.rays.service.DiseaseServiceInt;

@RestController
@RequestMapping(value = "Disease")
public class DiseaseCtl extends BaseCtl<DiseaseForm, DiseaseDTO, DiseaseServiceInt> {

}
