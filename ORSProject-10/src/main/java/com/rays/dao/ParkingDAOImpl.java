package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ParkingDTO;

@Repository
public class ParkingDAOImpl extends BaseDAOImpl<ParkingDTO> implements ParkingDAOInt {

	@Override
	public Class<ParkingDTO> getDTOClass() {
		return ParkingDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ParkingDTO dto, CriteriaBuilder builder, Root<ParkingDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getLocation())) {

			whereCondition.add(builder.like(qRoot.get("location"), dto.getLocation() + "%"));
		}

		return whereCondition;
	}
}
