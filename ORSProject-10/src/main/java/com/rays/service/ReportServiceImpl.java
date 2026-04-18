package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ReportDAOInt;
import com.rays.dto.ReportDTO;

@Service
@Transactional
public class ReportServiceImpl extends BaseServiceImpl<ReportDTO, ReportDAOInt> implements ReportServiceInt{

}
