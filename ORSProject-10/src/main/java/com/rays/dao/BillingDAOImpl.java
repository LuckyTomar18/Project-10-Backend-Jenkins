package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BillingDTO;

@Repository
public class BillingDAOImpl extends BaseDAOImpl<BillingDTO> implements BillingDAOInt {

	@Override
	public Class<BillingDTO> getDTOClass() {
		return BillingDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(BillingDTO dto, CriteriaBuilder builder, Root<BillingDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getBillingCode())) {

			whereCondition.add(builder.like(qRoot.get("billingCode"), dto.getBillingCode() + "%"));
		}

		return whereCondition;
	}

}
