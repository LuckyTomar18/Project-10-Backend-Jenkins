package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BuildDTO;

@Repository
public class BuildDAOImpl extends BaseDAOImpl<BuildDTO> implements BuildDAOInt {

	@Override
	public Class<BuildDTO> getDTOClass() {
		return BuildDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(BuildDTO dto, CriteriaBuilder builder, Root<BuildDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		
		if (!isEmptyString(dto.getBuildCode())) {

			whereCondition.add(builder.like(qRoot.get("buildCode"), dto.getBuildCode() + "%"));
		}

		if (!isEmptyString(dto.getBuildVersion())) {

			whereCondition.add(builder.like(qRoot.get("buildVersion"), dto.getBuildVersion() + "%"));
		}

		return whereCondition;
	}

}
