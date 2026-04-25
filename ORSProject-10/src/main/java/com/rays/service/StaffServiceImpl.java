package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StaffDAOInt;
import com.rays.dto.StaffDTO;

@Service
@Transactional
public class StaffServiceImpl extends BaseServiceImpl<StaffDTO, StaffDAOInt> implements StaffServiceInt{

}
