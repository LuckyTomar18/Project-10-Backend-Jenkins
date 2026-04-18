package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.HealthDTO;

@Repository
public class HealthDAOImpl extends BaseDAOImpl<HealthDTO> implements HealthDAOInt{

	@Override
	public Class<HealthDTO> getDTOClass() {
		return HealthDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(HealthDTO dto, CriteriaBuilder builder, Root<HealthDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getHealthCode())) {

			whereCondition.add(builder.like(qRoot.get("healthCode"), dto.getHealthCode() + "%"));
		}

		if (!isEmptyString(dto.getServiceName())) {

			whereCondition.add(builder.like(qRoot.get("serviceName"), dto.getServiceName() + "%"));
		}

		if (!isEmptyString(dto.getStatus())) {

			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}
		
		return whereCondition;
	}

}
