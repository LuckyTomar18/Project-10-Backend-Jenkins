package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RateDTO;

@Repository
public class RateDAOImpl extends BaseDAOImpl<RateDTO> implements RateDAOInt {

	@Override
	public Class<RateDTO> getDTOClass() {
		return RateDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(RateDTO dto, CriteriaBuilder builder, Root<RateDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getApiName())) {

			whereCondition.add(builder.like(qRoot.get("apiName"), dto.getApiName() + "%"));
		}

		
		return whereCondition;
		}

}
