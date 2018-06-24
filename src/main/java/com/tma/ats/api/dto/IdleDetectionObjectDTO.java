package com.tma.ats.api.dto;

public class IdleDetectionObjectDTO implements IdleDetectionObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;

	private String deviceId;
	private int priority;
	private String message;
	private String mail;
	private boolean enabled;
	private AlertTypeObject alertType;
	private double radius;
	private Double duration;

	/**
	 * IMPORTANT No-arg constructor is a MUST for GWT serializing/deserializing.
	 */
	public IdleDetectionObjectDTO() {
	}

	public IdleDetectionObjectDTO(Long objectId, int stamp, String deviceId,
			int priority, String message, String mail,
			AlertTypeObject alertType, boolean enabled, double radius, Double duration) {
		super();
		this.objectId = objectId;
		this.stamp = stamp;
		this.deviceId = deviceId;
		this.priority = priority;
		this.message = message;
		this.mail = mail;
		this.alertType = alertType;
		this.enabled = enabled;
		this.radius = radius;
		this.duration = duration;
	}

	@Override
	public int getStamp() {
		return stamp;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getMail() {
		return mail;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public AlertTypeObject getAlertTypeObject() {
		return alertType;
	}

	@Override
	public boolean isEnable() {
		return enabled;
	}
	
	@Override
	public double getRaidus() {
		return radius;
	}

	@Override
	public Double getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "IdleDetectionObjectDTO [objectId=" + objectId + ", stamp="
				+ stamp + ", deviceId=" + deviceId + ", priority=" + priority
				+ ", message=" + message + ", mail=" + mail + ", enabled="
				+ enabled + ", radius=" + radius + ", duration=" + duration + "]";
	}
}
