package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.DashboardDTO;

@Repository
public class DashboardDAOImpl extends BaseDAOImpl<DashboardDTO> implements DashboardDAOInt{

	@Override
	public Class<DashboardDTO> getDTOClass() {
		
		return DashboardDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(DashboardDTO dto, CriteriaBuilder builder, Root<DashboardDTO> qRoot) {
	
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getDashboardCode())) {

			whereCondition.add(builder.like(qRoot.get("dashboardCode"), dto.getDashboardCode() + "%"));
		}

		if (!isEmptyString(dto.getDashboardName())) {

			whereCondition.add(builder.like(qRoot.get("dashboardName"), dto.getDashboardName() + "%"));
		}

		return whereCondition;
	}

}
