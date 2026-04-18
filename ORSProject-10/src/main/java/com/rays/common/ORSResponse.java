package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard response wrapper for API responses.
 * It contains success status and result data such as message, data, and errors.
 * 
 * @author Lucky Tomar
 *
 */
public class ORSResponse {

	public static final String INPUT_ERROR = "inputerror";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";

	private Map<String, Object> result = new HashMap<String, Object>();

	public boolean success = false;

	/**
	 * Default constructor.
	 */
	public ORSResponse() {
	}

	/**
	 * Constructor with success flag.
	 * 
	 * @param success operation status
	 */
	public ORSResponse(boolean success) {
		this.success = success;
	}

	/**
	 * Constructor with success flag and message.
	 * 
	 * @param success operation status
	 * @param message response message
	 */
	public ORSResponse(boolean success, String message) {
		this.success = success;
		addMessage(message);
	}

	/**
	 * Constructor with success flag, message and data.
	 * 
	 * @param success operation status
	 * @param message response message
	 * @param value response data
	 */
	public ORSResponse(boolean success, String message, Object value) {
		this.success = success;
		addMessage(message);
		addData(value);
	}

	/**
	 * Returns success status.
	 * 
	 * @return true if successful
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets success status.
	 * 
	 * @param success operation status
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Returns result map.
	 * 
	 * @return result map
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * Sets result map.
	 * 
	 * @param result result data
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * Adds input validation errors.
	 * 
	 * @param value error details
	 */
	public void addInputError(Object value) {
		result.put(INPUT_ERROR, value);
	}

	/**
	 * Adds message to response.
	 * 
	 * @param value message
	 */
	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}

	/**
	 * Adds data to response.
	 * 
	 * @param value data object
	 */
	public void addData(Object value) {
		result.put(DATA, value);
	}

	/**
	 * Adds custom key-value pair to response.
	 * 
	 * @param key result key
	 * @param value result value
	 */
	public void addResult(String key, Object value) {
		result.put(key, value);
	}
}