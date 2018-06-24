package com.tma.ats.api.dto;

public class AlertStatusObjectDTO implements AlertStatusObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private AlertTypeObject alertType;
	private String status;

	public AlertStatusObjectDTO() {
	}

	public AlertStatusObjectDTO(Long objectId, AlertTypeObject alertType,
			String status) {
		super();
		this.objectId = objectId;
		this.alertType = alertType;
		this.status = status;
	}

	@Override
	public String toString() {
		return "AlertStatusObjectDTO [objectId=" + objectId + ", alertType="
				+ alertType + ", status=" + status + "]";
	}

	@Override
	public int getStamp() {
		return 0;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public AlertTypeObject getAlertTypeObject() {
		return alertType;
	}

	@Override
	public String getStatus() {
		return status;
	}
}