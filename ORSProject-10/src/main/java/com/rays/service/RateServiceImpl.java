package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.RateDAOInt;
import com.rays.dto.RateDTO;

@Service
@Transactional
public class RateServiceImpl extends BaseServiceImpl<RateDTO, RateDAOInt> implements RateServiceInt{

}
