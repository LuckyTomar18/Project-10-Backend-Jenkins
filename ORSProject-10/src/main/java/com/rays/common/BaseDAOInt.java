package com.rays.common;

import java.util.List;

/**
 * Base DAO Interface defining common database operations.
 * 
 * @author Lucky Tomar
 *
 * @param <T> DTO class extending BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

	/**
	 * Adds a new record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return Generated ID
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Deletes a record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 */
	public void delete(T dto, UserContext userContext);

	/**
	 * Finds record by primary key.
	 * 
	 * @param pk Primary key
	 * @param userContext User context
	 * @return DTO object
	 */
	public T findByPK(long pk, UserContext userContext);

	/**
	 * Finds record by unique key.
	 * 
	 * @param attribute Attribute name
	 * @param val Attribute value
	 * @param userContext User context
	 * @return DTO object if found
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext);

	/**
	 * Searches records with pagination.
	 * 
	 * @param dto DTO object
	 * @param pageNo Page number
	 * @param pageSize Page size
	 * @param userContext User context
	 * @return List of results
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Searches records without pagination.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return List of results
	 */
	public List search(T dto, UserContext userContext);

}