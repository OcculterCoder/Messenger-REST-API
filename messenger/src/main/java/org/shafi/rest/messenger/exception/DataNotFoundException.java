package org.shafi.rest.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4300602392743860791L;
	
	public DataNotFoundException(String erMessage) {
		super(erMessage);
	}
	
}
