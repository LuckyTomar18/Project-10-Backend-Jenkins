package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.VenueDTO;
import com.rays.form.VenueForm;
import com.rays.service.VenueServiceInt;

@RestController
@RequestMapping(value="Venue")
public class VenueCtl extends BaseCtl<VenueForm , VenueDTO, VenueServiceInt> {

}
