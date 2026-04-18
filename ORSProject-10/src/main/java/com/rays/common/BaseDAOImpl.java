



	package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Base DAO Implementation providing common database operations.
 * 
 * @author Lucky Tomar
 *
 * @param <T> DTO class extending BaseDTO
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Returns DTO class type.
	 * 
	 * @return Class of DTO
	 */
	public abstract Class<T> getDTOClass();

	/**
	 * Builds dynamic where clause predicates.
	 * 
	 * @param dto DTO object
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root entity
	 * @return List of predicates
	 */
	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

	/**
	 * Hook method for populating additional fields before persist/update.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 */
	protected void populate(T dto, UserContext userContext) {
	}

	/**
	 * Adds a new record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return Generated ID
	 */
	public long add(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLoginId());
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}

	/**
	 * Updates an existing record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 */
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);
	}

	/**
	 * Deletes a record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 */
	public void delete(T dto, UserContext userContext) {
		entityManager.remove(dto);
	}

	/**
	 * Finds record by primary key.
	 * 
	 * @param pk Primary key
	 * @param userContext User context
	 * @return DTO object
	 */
	public T findByPK(long pk, UserContext userContext) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	/**
	 * Finds record by unique key.
	 * 
	 * @param attribute Attribute name
	 * @param val Attribute value
	 * @param userContext User context
	 * @return DTO object if found
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext) {

		Class<T> dtoClass = getDTOClass();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<T> cq = builder.createQuery(dtoClass);

		Root<T> qRoot = cq.from(dtoClass);

		Predicate condition = builder.equal(qRoot.get(attribute), val);

		cq.where(condition);

		TypedQuery<T> query = entityManager.createQuery(cq);

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}

		return dto;
	}

	/**
	 * Creates criteria query with dynamic filters.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return TypedQuery object
	 */
	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());

		Root<T> qRoot = cq.from(getDTOClass());

		cq.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);

		cq.where(whereClause.toArray(new Predicate[whereClause.size()]));

		TypedQuery<T> query = entityManager.createQuery(cq);

		return query;
	}
	
	
	/**
	 * Returns top 10 records based on HQL (used for merit list).
	 * 
	 * @param hql HQL query string
	 * @param userContext User context
	 * @return List of results
	 */
	public List marksheetMeritList(String hql, UserContext userContext) {
		Query q = entityManager.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(10);
		List l = q.getResultList();
		return l;
	}

	/**
	 * Searches records with pagination.
	 * 
	 * @param dto DTO object
	 * @param pageNo Page number
	 * @param pageSize Page size
	 * @param userContext User context
	 * @return List of results
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {

		TypedQuery<T> query = createCriteria(dto, userContext);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List list = query.getResultList();
		return list;
	}

	/**
	 * Searches records without pagination.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return List of results
	 */
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	/**
	 * Checks if string is null or empty.
	 * 
	 * @param val String value
	 * @return true if empty
	 */
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	/**
	 * Checks if Double value is zero or null.
	 * 
	 * @param val Double value
	 * @return true if zero
	 */
	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	/**
	 * Checks if Long value is zero or null.
	 * 
	 * @param val Long value
	 * @return true if zero
	 */
	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	/**
	 * Checks if Integer value is zero or null.
	 * 
	 * @param val Integer value
	 * @return true if zero
	 */
	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	/**
	 * Checks if object is not null.
	 * 
	 * @param val Object value
	 * @return true if not null
	 */
	protected boolean isNotNull(Object val) {
		return val != null;
	}
}