package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.GeoDAOInt;
import com.rays.dto.GeoDTO;

@Service
@Transactional
public class GeoServiceImpl extends BaseServiceImpl<GeoDTO, GeoDAOInt> implements GeoServiceInt{

}
