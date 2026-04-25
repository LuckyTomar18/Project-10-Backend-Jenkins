package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.DivisionDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.StaffDTO;
import com.rays.dto.UserDTO;

@Repository
public class StaffDAOImpl extends BaseDAOImpl<StaffDTO> implements StaffDAOInt {

	@Autowired
	DivisionDAOInt divisionDao;
	
	@Override
	protected void populate(StaffDTO dto, UserContext userContext) {
		if (dto.getDivisionId() != null && dto.getDivisionId() > 0) {
			DivisionDTO divisionDto = divisionDao.findByPK(dto.getDivisionId(), userContext);
			dto.setDivisionName(divisionDto.getDivision());
		}
	}
		
	@Override
	public Class<StaffDTO> getDTOClass() {
		return StaffDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(StaffDTO dto, CriteriaBuilder builder, Root<StaffDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFullName())) {

			whereCondition.add(builder.like(qRoot.get("fullName"), dto.getFullName() + "%"));
		}

		if (!isEmptyString(dto.getEmployeeCode())) {

			whereCondition.add(builder.like(qRoot.get("employeeCode"), dto.getEmployeeCode() + "%"));
		}

		if (!isZeroNumber(dto.getDivisionId())) {

			whereCondition.add(builder.equal(qRoot.get("divisionId"), dto.getDivisionId()));
		}

		if (isNotNull(dto.getJoiningDate())) {

			whereCondition.add(builder.equal(qRoot.get("joiningDate"), dto.getJoiningDate()));
		}

		return whereCondition;
	}

}
