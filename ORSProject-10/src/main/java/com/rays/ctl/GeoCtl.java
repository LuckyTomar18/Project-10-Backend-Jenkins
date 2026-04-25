package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.GeoDTO;
import com.rays.form.GeoForm;
import com.rays.service.GeoServiceInt;

@RestController
@RequestMapping(value="Geo")
public class GeoCtl extends BaseCtl<GeoForm, GeoDTO, GeoServiceInt> {

}
