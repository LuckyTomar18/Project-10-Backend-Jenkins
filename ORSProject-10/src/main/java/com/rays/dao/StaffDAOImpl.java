package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.StaffDTO;

@Repository
public class StaffDAOImpl extends BaseDAOImpl<StaffDTO> implements StaffDAOInt {

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

		if (!isEmptyString(dto.getDivision())) {

			whereCondition.add(builder.like(qRoot.get("division"), dto.getDivision() + "%"));
		}

		if (isNotNull(dto.getJoiningDate())) {

			whereCondition.add(builder.equal(qRoot.get("joiningDate"), dto.getJoiningDate()));
		}

		return whereCondition;
	}

}
