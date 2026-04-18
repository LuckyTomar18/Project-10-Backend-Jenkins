package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.VenueDTO;

/**
 * VenueDAOImpl is the DAO implementation class for Venue entity.
 * 
 * It extends BaseDAOImpl to inherit common CRUD operations
 * such as save, update, delete, and search.
 * 
 * This class handles:
 * - Dynamic query creation using JPA Criteria API
 * - Filtering based on venue name and city
 * 
 * @author Lucky Tomar
 *
 */
@Repository
public class VenueDAOImpl extends BaseDAOImpl<VenueDTO> implements VenueDAOInt{

	/**
	 * Returns the DTO class type.
	 * 
	 * @return VenueDTO class
	 */
	@Override
	public Class<VenueDTO> getDTOClass() {
		return VenueDTO.class;
	}

	/**
	 * Builds dynamic where clause for Venue search.
	 * 
	 * Filters applied:
	 * - Venue Name (starts with)
	 * - City (starts with)
	 * 
	 * @param dto search criteria
	 * @param builder CriteriaBuilder
	 * @param qRoot Root entity reference
	 * @return list of predicates
	 */
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