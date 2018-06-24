package com.tma.ats.api.dto;

public class TheftDetectionObjectDTO implements TheftDetectionObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;

	private String deviceId;
	private int priority;
	private String message;
	private String mail;
	private boolean enabled;
	private AlertTypeObject alertType;

	/**
	 * IMPORTANT No-arg constructor is a MUST for GWT serializing/deserializing.
	 */
	public TheftDetectionObjectDTO() {
	}

	public TheftDetectionObjectDTO(Long objectId, int stamp, String deviceId,
			int priority, String message, String mail,
			AlertTypeObject alertType, boolean enabled) {
		super();
		this.objectId = objectId;
		this.stamp = stamp;
		this.deviceId = deviceId;
		this.priority = priority;
		this.message = message;
		this.mail = mail;
		this.alertType = alertType;
		this.enabled = enabled;
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
	public boolean getEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		return "TheftDetectionObjectDTO [objectId=" + objectId + ", stamp="
				+ stamp + ", deviceId=" + deviceId + ", priority=" + priority
				+ ", message=" + message + ", mail=" + mail + ", enabled="
				+ enabled + "]";
	}
}
