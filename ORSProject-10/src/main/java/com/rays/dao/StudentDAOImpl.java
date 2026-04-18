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
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;

/**
 * StudentDAOImpl is the DAO implementation class for Student entity.
 * 
 * It extends BaseDAOImpl to inherit common CRUD operations
 * such as save, update, delete, and search.
 * 
 * This class handles:
 * - Dynamic query creation using JPA Criteria API
 * - Population of related entity data (College)
 * 
 * @author Lucky Tomar
 *
 */
@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

	@Autowired
	CollegeDAOInt collegeService = null;

	/**
	 * Returns the DTO class type.
	 * 
	 * @return StudentDTO class
	 */
	@Override
	public Class<StudentDTO> getDTOClass() {
		return StudentDTO.class;
	}

	/**
	 * Populates college name using collegeId.
	 * 
	 * @param dto StudentDTO object
	 * @param userContext current user context
	 */
	@Override
	protected void populate(StudentDTO dto, UserContext userContext) {
		CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId(), userContext);
		if (collegeDTO != null) {
			dto.setCollegeName(collegeDTO.getName());
		}
	}

	/**
	 * Builds dynamic where clause for Student search.
	 * 
	 * Filters applied:
	 * - Enrollment Number (starts with)
	 * - First Name (starts with)
	 * - College Name (starts with)
	 * - Email (starts with)
	 * - Date of Birth (exact match)
	 * - Phone Number (starts with)
	 * 
	 * @param dto search criteria
	 * @param builder CriteriaBuilder
	 * @param qRoot Root entity reference
	 * @return list of predicates
	 */
	@Override
	protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getEnrolNo())) {

			whereCondition.add(builder.like(qRoot.get("enrolNo"), dto.getEnrolNo() + "%"));
		}
		
		if (!isEmptyString(dto.getFirstName())) {

			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {

			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {

			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}

		if (isNotNull(dto.getDob())) {

			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}

		if (!isEmptyString(dto.getPhoneNo())) {
			whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
		}

		return whereCondition;
	}
}