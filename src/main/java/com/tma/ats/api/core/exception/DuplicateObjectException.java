package com.tma.ats.api.core.exception;

public class DuplicateObjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DuplicateObjectException() {
        super();
    }

    public DuplicateObjectException(String message) {
        super(message);
    }

}
