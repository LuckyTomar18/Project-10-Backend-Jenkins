package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.FilterDTO;

@Repository
public class FilterDAOImpl extends BaseDAOImpl<FilterDTO> implements FilterDAOInt {

	@Override
	public Class<FilterDTO> getDTOClass() {
		return FilterDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(FilterDTO dto, CriteriaBuilder builder, Root<FilterDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFilterCode())) {

			whereCondition.add(builder.like(qRoot.get("filterCode"), dto.getFilterCode() + "%"));
		}
		
		if (!isEmptyString(dto.getFilterName())) {

			whereCondition.add(builder.like(qRoot.get("filterName"), dto.getFilterName() + "%"));
		}

		

		return whereCondition;
	}

	}


