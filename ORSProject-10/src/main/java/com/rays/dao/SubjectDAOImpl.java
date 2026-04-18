package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;

/**
 * SubjectDAOImpl is the DAO implementation class for Subject entity.
 * 
 * It extends BaseDAOImpl to inherit common CRUD operations
 * such as save, update, delete, and search.
 * 
 * This class handles:
 * - Dynamic query creation using JPA Criteria API
 * - Population of related entity data (Course)
 * 
 * @author Lucky Tomar
 *
 */
@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

	@Autowired
	CourseDAOInt courseDao;

	/**
	 * Returns the DTO class type.
	 * 
	 * @return SubjectDTO class
	 */
	@Override
	public Class<SubjectDTO> getDTOClass() {
		return SubjectDTO.class;
	}

	/**
	 * Populates course name using courseId.
	 * 
	 * @param dto SubjectDTO object
	 * @param userContext current user context
	 */
	@Override
	protected void populate(SubjectDTO dto, UserContext userContext) {
		if (dto.getCourseId() != 0) {
			CourseDTO courseDTO = courseDao.findByPK(dto.getCourseId(), userContext);
			if (courseDTO != null) {
				dto.setCourseName(courseDTO.getName());
			}
		}
	}

	/**
	 * Builds dynamic where clause for Subject search.
	 * 
	 * Filters applied:
	 * - Name (starts with)
	 * - Course Name (starts with)
	 * 
	 * @param dto search criteria
	 * @param builder CriteriaBuilder
	 * @param qRoot Root entity reference
	 * @return list of predicates
	 */
	@Override
	protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		return whereCondition;
	}
}