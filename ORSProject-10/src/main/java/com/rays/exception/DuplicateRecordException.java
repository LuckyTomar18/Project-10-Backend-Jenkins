package com.rays.exception;

/**
 * DuplicateRecordException is a custom runtime exception used to indicate
 * that a duplicate record already exists in the database.
 * 
 * It is typically thrown during add or update operations
 * when a unique constraint is violated (e.g., duplicate email, username).
 * 
 * This helps in handling business-level validation errors
 * separately from system or database errors.
 * 
 * @author Lucky Tomar
 *
 */
public class DuplicateRecordException extends RuntimeException {

	/**
	 * Constructor to initialize exception with message.
	 * 
	 * @param msg error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}