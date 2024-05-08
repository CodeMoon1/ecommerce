package com.souza.projeto.services.exceptions;

public class DatabaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseException(String msm) {
		super(msm);
	}

}
