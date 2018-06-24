package com.tma.ats.api.core.exception;

public class StampMismatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public StampMismatchException() {
        super();
    }

    public StampMismatchException(String message) {
        super(message);
    }
}
