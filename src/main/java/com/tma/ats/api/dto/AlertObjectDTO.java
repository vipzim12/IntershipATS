package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.db.entity.AlertAckState;

public class AlertObjectDTO implements AlertObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;

	private String deviceId;
	private AlertAckState alertAckState;
	private Date raisedTime;
	private String acknowledgedBy;
	private boolean resolved;
	private Date resolveTime;
	private String resolveMessage;
	private AlertTypeObject alertTypeObject;
	private AlertStatusObject alertStatusObject;

	public AlertObjectDTO() {
	}

	public AlertObjectDTO(Long objectId, int stamp, String deviceId,
			AlertAckState alertAckState, Date raisedTime, String acknowledgedBy,
			boolean resolved, Date resolveTime, String resolveMessage,
			AlertTypeObject alertTypeObject, AlertStatusObject alertStatusObject) {
		super();
		this.objectId = objectId;
		this.stamp = stamp;
		this.deviceId = deviceId;
		this.alertAckState = alertAckState;
		this.raisedTime = raisedTime;
		this.acknowledgedBy = acknowledgedBy;
		this.resolved = resolved;
		this.resolveTime = resolveTime;
		this.resolveMessage = resolveMessage;
		this.alertTypeObject = alertTypeObject;
		this.alertStatusObject = alertStatusObject;
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
	public AlertAckState getAlertAckState() {
		return alertAckState;
	}

	@Override
	public Date getRaisedTime() {
		return raisedTime;
	}

	@Override
	public String getAcknowledgedBy() {
		return acknowledgedBy;
	}

	@Override
	public boolean getResolved() {
		return resolved;
	}

	@Override
	public Date getResolveTime() {
		return resolveTime;
	}

	@Override
	public String getResolveMessage() {
		return resolveMessage;
	}

	@Override
	public AlertTypeObject getAlertTypeObject() {
		return alertTypeObject;
	}

	@Override
	public AlertStatusObject getAlertStatusObject() {
		return alertStatusObject;
	}
	
	@Override
	public String toString() {
		return "AlertObjectDTO [objectId=" + objectId + ", stamp=" + stamp
				+ ", deviceId=" + deviceId + ", alertAckState=" + alertAckState
				+ ", raisedTime=" + raisedTime + ", acknowledgedBy="
				+ acknowledgedBy + ", resolved=" + resolved + ", resolveTime="
				+ resolveTime + ", resolveMessage=" + resolveMessage
				+ ", alertTypeObject=" + alertTypeObject
				+ ", alertStatusObject=" + alertStatusObject + "]";
	}
}