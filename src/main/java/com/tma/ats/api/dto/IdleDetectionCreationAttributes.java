package com.tma.ats.api.dto;

import java.io.Serializable;

public class IdleDetectionCreationAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private int priority;
	private String message;
	private String mail;
	private String deviceId;
	private Double radius;
	private Double duration;	

	public IdleDetectionCreationAttributes() {
	}

	public IdleDetectionCreationAttributes(int priority, String message,
			String mail, String deviceId, Double radius, Double duration) {
		this.priority = priority;
		this.message = message;
		this.mail = mail;
		this.deviceId = deviceId;
		this.radius = radius;
		this.duration = duration;	
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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