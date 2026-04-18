package com.rays.common;

/**
 * Interface for dropdown list values.
 * Provides key-value pair representation for UI components.
 * 
 * @author Lucky Tomar
 *
 */
public interface DropdownList {

	/**
	 * Returns key for dropdown (usually ID).
	 * 
	 * @return key
	 */
	public String getKey();

	/**
	 * Returns value for dropdown (display name).
	 * 
	 * @return value
	 */
	public String getValue();

}