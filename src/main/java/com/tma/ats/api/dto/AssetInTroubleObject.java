package com.tma.ats.api.dto;

import com.tma.ats.api.db.entity.AlertAckState;

public class AssetInTroubleObject extends AlertObjectDTO {
	private Long objectId;
	private String identifier;
	private int priority;
	private AlertAckState alertAckState;
	private String deviceId;
	private static final long serialVersionUID = 1L;

	public AssetInTroubleObject() {
	}

	public AssetInTroubleObject(Long objectId, String identifier,
			AlertAckState alertAckState, int priority, String deviceId) {
		super();
		this.objectId = objectId;
		this.priority = priority;
		this.identifier = identifier;
		this.alertAckState = alertAckState;
		this.deviceId = deviceId;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	public String getIdentifier() {
		return identifier;
	}

	public int getPriority() {
		return priority;
	}

	public AlertAckState getAlertAckState() {
		return alertAckState;
	}

	public void setAlertAckState(AlertAckState alertAckState) {
		this.alertAckState = alertAckState;
	}

	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public String toString() {
		return "AssetInTroubleObject [identifier=" + identifier + ", priority="
				+ priority + ", alertAckState=" + alertAckState + ", deviceId="
				+ deviceId + "]";
	}
}
