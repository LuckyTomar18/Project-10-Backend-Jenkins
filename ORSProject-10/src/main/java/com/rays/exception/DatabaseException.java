package com.rays.exception;

/**
 * DatabaseException is a custom runtime exception used to handle
 * database-related errors in the application.
 * 
 * It is typically thrown when a database operation fails
 * or when a requested record is not found.
 * 
 * This exception helps in separating database-specific errors
 * from other types of exceptions.
 * 
 * @author Lucky Tomar
 *
 */
public class DatabaseException extends RuntimeException {

	/**
	 * Constructor to initialize exception with message.
	 * 
	 * @param msg error message
	 */
	public DatabaseException(String msg) {
		super(msg);
	}
}