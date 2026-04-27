package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.DivisionDAOInt;
import com.rays.dto.DivisionDTO;

@Service
@Transactional
public class DivisionServiceImpl extends BaseServiceImpl<DivisionDTO, DivisionDAOInt> implements DivisionServiceInt {

	@Transactional(readOnly = true)
	public DivisionDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("division", name, userContext);
	}
}
