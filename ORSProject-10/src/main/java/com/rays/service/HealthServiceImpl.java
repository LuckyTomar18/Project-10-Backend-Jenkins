package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.HealthDAOInt;
import com.rays.dto.HealthDTO;

@Service
@Transactional
public class HealthServiceImpl extends BaseServiceImpl<HealthDTO, HealthDAOInt> implements HealthServiceInt {

}
