package com.tma.ats.api.core.exception;

public class ObjectInUseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectInUseException() {
        super();
    }

    public ObjectInUseException(String message) {
        super(message);
    }
}
