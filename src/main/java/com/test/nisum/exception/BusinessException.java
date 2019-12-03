package com.test.nisum.exception;

import java.util.Map;

/**
 * 
 * @author Christian Rojas N.
 *
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 6629839332879623981L;

	private final Map<String, String> errors;

	public BusinessException(Map<String, String> errors, String message, Throwable cause) {
		super(message, cause);
		this.errors = errors;
	}

	public BusinessException(Map<String, String> errors, String message) {
		super(message);
		this.errors = errors;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.errors = null;
	}

	public BusinessException(String message) {
		super(message);
		this.errors = null;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

}
