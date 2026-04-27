package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ParkingDTO;
import com.rays.form.ParkingForm;
import com.rays.service.ParkingServiceInt;

@RestController
@RequestMapping(value="Parking")
public class ParkingCtl extends BaseCtl<ParkingForm, ParkingDTO, ParkingServiceInt>{
	
	
}