package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.VenueDAOInt;
import com.rays.dto.VenueDTO;

@Service
@Transactional
public class VenueServiceImpl extends BaseServiceImpl<VenueDTO, VenueDAOInt> implements VenueServiceInt{

}
