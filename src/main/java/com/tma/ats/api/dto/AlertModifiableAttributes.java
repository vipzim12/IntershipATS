package com.tma.ats.api.dto;

import java.io.Serializable;

public class AlertModifiableAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private String message;

	public AlertModifiableAttributes() {
	}

	public AlertModifiableAttributes(long alertId, String message) {
		this.objectId = alertId;
		this.message = message;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
