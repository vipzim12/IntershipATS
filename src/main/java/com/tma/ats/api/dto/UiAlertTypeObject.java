package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.db.entity.AlertAckState;

public class UiAlertTypeObject extends AlertTypeObjectDTO {
	private Long objectId;
	private String name;
	private String status;
	private int priority;
	private String description;
	private Date raisedTime;
	private String acknowledgedBy;
	private AlertAckState alertAckState;
	private String messageHistory;
	private static final long serialVersionUID = 1L;

	public UiAlertTypeObject() {
	}

	public UiAlertTypeObject(Long objectId, String name, String description,
			String status, int priority, Date raisedTime,
			String acknowledgedBy, AlertAckState alertAckState,
			String messageHistory) {
		this.objectId = objectId;
		this.name = name;
		this.status = status;
		this.priority = priority;
		this.raisedTime = raisedTime;
		this.description = description;
		this.acknowledgedBy = acknowledgedBy;
		this.alertAckState = alertAckState;
		this.messageHistory = messageHistory;
	}

	public Long getObjectId() {
		return objectId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public int getPriority() {
		return priority;
	}

	public Date getRaisedTime() {
		return raisedTime;
	}

	public String getAcknowledgedBy() {
		return acknowledgedBy;
	}

	public AlertAckState getAlertAckState() {
		return alertAckState;
	}

	public String getMessageHistory() {
		return messageHistory;
	}

	@Override
	public String toString() {
		return "UiAlertTypeObject [objectId=" + objectId + ", acknowledgedBy="
				+ acknowledgedBy + ", status=" + status + ", alertAckState="
				+ alertAckState + ", messageHistory="
						+ messageHistory + "]";
	}
}
