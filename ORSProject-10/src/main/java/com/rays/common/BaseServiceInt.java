package com.rays.common;

import java.util.List;

/**
 * Base Service Interface defining common business operations.
 * It acts as a contract between Controller and Service layer.
 * 
 * @author Lucky Tomar
 *
 * @param <T> DTO class extending BaseDTO
 */
public interface BaseServiceInt<T extends BaseDTO> {

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
	 * Saves a record (add or update).
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return ID of saved record
	 */
	public long save(T dto, UserContext userContext);

	/**
	 * Deletes a record by ID.
	 * 
	 * @param id Record ID
	 * @param userContext User context
	 * @return Deleted DTO object
	 */
	public T delete(long id, UserContext userContext);

	/**
	 * Finds record by ID.
	 * 
	 * @param id Record ID
	 * @param userContext User context
	 * @return DTO object
	 */
	public T findById(long id, UserContext userContext);

	/**
	 * Finds record by unique key.
	 * 
	 * @param attribute Attribute name
	 * @param val Attribute value
	 * @param userContext User context
	 * @return DTO object
	 */
	public T findByUniqueKey(String attribute, String val, UserContext userContext);

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