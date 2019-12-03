package com.test.nisum.exception;

/**
 * 
 * @author Christian Rojas N.
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 443656413406943195L;

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

}
