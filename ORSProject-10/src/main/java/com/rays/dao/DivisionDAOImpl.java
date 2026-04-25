package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.DivisionDTO;

@Repository
@Transactional
public class DivisionDAOImpl extends BaseDAOImpl<DivisionDTO> implements DivisionDAOInt {

	@Override
	public Class<DivisionDTO> getDTOClass() {
		return DivisionDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(DivisionDTO dto, CriteriaBuilder builder, Root<DivisionDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}
		return whereCondition;
	}

}
