package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FilterDAOInt;
import com.rays.dto.FilterDTO;

@Service
@Transactional
public class FilterServiceImpl extends BaseServiceImpl<FilterDTO, FilterDAOInt> implements FilterServiceInt {

}
