package com.tma.ats.api.core.exception;

public class InvalidValueException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidValueException() {
        super();
    }

    public InvalidValueException(String message) {
        super(message);
    }

}
