package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * Base Service Implementation providing common business operations.
 * It acts as a bridge between Controller and DAO layer.
 * 
 * @author Lucky Tomar
 *
 * @param <T> DTO class extending BaseDTO
 * @param <D> DAO interface extending BaseDAOInt
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	@Autowired
	protected D baseDao;

	/**
	 * Adds a new record.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return Generated ID
	 * @throws DuplicateRecordException if duplicate record exists
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto, UserContext userContext) throws DuplicateRecordException {
		long pk = baseDao.add(dto, userContext);
		return pk;
	}

	/**
	 * Updates an existing record.
	 * Preserves createdBy and createdDatetime fields.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @throws DuplicateRecordException if duplicate record exists
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) throws DuplicateRecordException {

		T oldDto = baseDao.findByPK(dto.getId(), userContext);

		if (oldDto != null) {
			dto.setCreatedBy(oldDto.getCreatedBy());
			dto.setCreatedDatetime(oldDto.getCreatedDatetime());
		}

		baseDao.update(dto, userContext);
	}

	/**
	 * Saves a record (add or update based on ID).
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return ID of saved record
	 * @throws DuplicateRecordException if duplicate record exists
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext) throws DuplicateRecordException {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto, userContext);
		} else {
			id = add(dto, userContext);
		}
		return id;
	}

	/**
	 * Finds record by ID.
	 * 
	 * @param id Record ID
	 * @param userContext User context
	 * @return DTO object
	 */
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto = baseDao.findByPK(id, userContext);
		return dto;
	}

	/**
	 * Deletes a record by ID.
	 * 
	 * @param id Record ID
	 * @param userContext User context
	 * @return Deleted DTO object
	 * @throws DatabaseException if record not found
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) {
		T dto = findById(id, userContext);
		if (dto == null) {
			throw new DatabaseException("Record not found");
		}
		baseDao.delete(dto, userContext);
		return dto;
	}

	/**
	 * Finds record by unique key.
	 * 
	 * @param attribute Attribute name
	 * @param val Attribute value
	 * @param userContext User context
	 * @return DTO object
	 */
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val, UserContext userContext) {
		T dto = baseDao.findByUniqueKey(attribute, val, userContext);
		return dto;
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
	@Transactional(readOnly = true)
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
		return baseDao.search(dto, pageNo, pageSize, userContext);
	}

	/**
	 * Searches records without pagination.
	 * 
	 * @param dto DTO object
	 * @param userContext User context
	 * @return List of results
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, UserContext userContext) {
		return baseDao.search(dto, userContext);
	}
}