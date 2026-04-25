package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.DivisionDAOInt;
import com.rays.dto.DivisionDTO;
import com.rays.dto.RoleDTO;

@Service
@Transactional
public class DivisionServiceImpl extends BaseServiceImpl<DivisionDTO, DivisionDAOInt> implements DivisionServiceInt{

	public DivisionDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("division", name, userContext);
	}
}
