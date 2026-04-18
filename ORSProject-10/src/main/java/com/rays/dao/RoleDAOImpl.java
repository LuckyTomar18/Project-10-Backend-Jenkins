package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RoleDTO;

/**
 * RoleDAOImpl is the DAO implementation class for Role entity.
 * 
 * It extends BaseDAOImpl to inherit common CRUD operations
 * such as save, update, delete, and search.
 * 
 * This class builds dynamic query conditions using JPA Criteria API
 * based on provided search parameters.
 * 
 * @author Lucky Tomar
 *
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

	/**
	 * Returns the DTO class type.
	 * 
	 * @return RoleDTO class
	 */
	@Override
	public Class<RoleDTO> getDTOClass() {
		return RoleDTO.class;
	}
	
	/**
	 * Builds dynamic where clause for Role search.
	 * 
	 * Filters applied:
	 * - ID (exact match)
	 * - Name (starts with)
	 * 
	 * @param dto search criteria
	 * @param builder CriteriaBuilder
	 * @param qRoot Root entity reference
	 * @return list of predicates
	 */
	@Override
	protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		return whereCondition;
	}
	
}