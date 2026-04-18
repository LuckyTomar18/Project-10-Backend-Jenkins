package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DashboardDAOInt;
import com.rays.dto.DashboardDTO;

@Service
public class DashboardServiceImpl extends BaseServiceImpl<DashboardDTO, DashboardDAOInt> implements DashboardServiceInt{

}
