package com.rays.common;

/**
 * Base Form class for handling common form properties.
 * It is used to transfer data between UI and backend.
 * 
 * @author Lucky Tomar
 *
 */
public class BaseForm {

	protected Long id;

	protected String createdBy;

	protected String modifiedBy;

	protected long createdDatetime;

	protected long modifiedDatetime;

	private Long[] ids;

	private int pageNo = 0;

	private int pageSize = 5;

	private String operation;

	/**
	 * Gets ID.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets ID.
	 * 
	 * @param id primary key
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Converts form into DTO.
	 * Should be overridden in child classes.
	 * 
	 * @return BaseDTO object
	 */
	public BaseDTO getDto() {
		return null;
	}

	/**
	 * Initializes DTO with ID value.
	 * 
	 * @param dto DTO object
	 * @param <T> Type extending BaseDTO
	 * @return initialized DTO
	 */
	public <T extends BaseDTO> T initDTO(T dto) {
		System.out.println("id => base dto => " + id);
		if (id != null && id > 0) {
			dto.setId(id);
		} else {
			dto.setId(null);
		}
		return dto;
	}
}