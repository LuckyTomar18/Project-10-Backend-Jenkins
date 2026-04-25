package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.GeoDTO;

@Repository
public class GeoDAOImpl extends BaseDAOImpl<GeoDTO> implements GeoDAOInt {

	@Override
	public Class<GeoDTO> getDTOClass() {
		return GeoDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(GeoDTO dto, CriteriaBuilder builder, Root<GeoDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getGeoFenceCode())) {

			whereCondition.add(builder.like(qRoot.get("geoFenceCode"), dto.getGeoFenceCode() + "%"));
		}

		return whereCondition;
	}

}
