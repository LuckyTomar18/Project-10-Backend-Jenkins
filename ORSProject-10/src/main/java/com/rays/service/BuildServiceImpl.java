package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.BuildDAOInt;
import com.rays.dto.BuildDTO;

@Service
@Transactional
public class BuildServiceImpl extends BaseServiceImpl<BuildDTO, BuildDAOInt> implements BuildServiceInt {


}
