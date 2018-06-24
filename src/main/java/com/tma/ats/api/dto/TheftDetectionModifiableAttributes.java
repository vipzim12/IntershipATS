package com.tma.ats.api.dto;

import java.io.Serializable;

public class TheftDetectionModifiableAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private int priority;
	private String message;
	private String mail;
	private boolean enabled;
	
	public TheftDetectionModifiableAttributes() {
	}

	public TheftDetectionModifiableAttributes(TheftDetectionObject theftDetection) {
		this.objectId = theftDetection.getObjectId();
		this.stamp = theftDetection.getStamp();
		this.priority = theftDetection.getPriority();
		this.message = theftDetection.getMessage();
		this.mail = theftDetection.getMail();
		this.enabled = theftDetection.getEnabled();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}