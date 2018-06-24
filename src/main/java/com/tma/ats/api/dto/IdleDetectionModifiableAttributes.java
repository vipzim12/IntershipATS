package com.tma.ats.api.dto;

import java.io.Serializable;

public class IdleDetectionModifiableAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private int priority;
	private String message;
	private String mail;
	private boolean enabled;
	private Double radius;
	private Double duration;
	
	public IdleDetectionModifiableAttributes() {
	}

	public IdleDetectionModifiableAttributes(IdleDetectionObject idle) {
		this.objectId = idle.getObjectId();
		this.stamp = idle.getStamp();
		this.priority = idle.getPriority();
		this.message = idle.getMessage();
		this.mail = idle.getMail();
		this.enabled = idle.isEnable();
		this.radius = idle.getRaidus();
		this.duration = idle.getDuration();
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
	
	public Double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
}