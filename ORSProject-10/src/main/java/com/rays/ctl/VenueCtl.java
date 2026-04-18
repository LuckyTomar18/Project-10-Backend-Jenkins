package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.VenueDTO;
import com.rays.form.VenueForm;
import com.rays.service.VenueServiceInt;

/**
 * VenueCtl is a REST controller for handling Venue-related operations.
 * 
 * It extends BaseCtl to inherit common CRUD functionalities
 * such as add, update, delete, search, and get by ID.
 * 
 * This controller delegates business logic to VenueService.
 * 
 * @author Lucky Tomar
 *
 */
@RestController
@RequestMapping(value="Venue")
public class VenueCtl extends BaseCtl<VenueForm , VenueDTO, VenueServiceInt> {

}