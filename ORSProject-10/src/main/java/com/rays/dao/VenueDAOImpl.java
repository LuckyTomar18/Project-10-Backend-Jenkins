package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.VenueDTO;

@Repository
public class VenueDAOImpl extends BaseDAOImpl<VenueDTO> implements VenueDAOInt{

	@Override
	public Class<VenueDTO> getDTOClass() {
		return VenueDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(VenueDTO dto, CriteriaBuilder builder, Root<VenueDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getVenueName())) {
			whereCondition.add(builder.like(qRoot.get("venueName"), dto.getVenueName() + "%"));
		}
		if (!isEmptyString(dto.getCity())) {
			whereCondition.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
		}
		return whereCondition;
	}

}
