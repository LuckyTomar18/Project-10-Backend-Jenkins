package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ParkingDAOInt;
import com.rays.dto.ParkingDTO;
@Service
@Transactional
public class ParkingServiceImpl extends BaseServiceImpl<ParkingDTO, ParkingDAOInt> implements ParkingServiceInt {

}
