package com.tma.ats.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.tma.ats.api.db.entity.EventType;

public class AlertLogCreationAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private EventType eventType;
	private Date eventTime;
	private String message;
	private long alertId;

	public AlertLogCreationAttributes() {
	}

	public AlertLogCreationAttributes(EventType eventType, Date eventTime,
			String message, long alertId) {
		this.eventTime = eventTime;
		this.eventType = eventType;
		this.message = message;
		this.alertId = alertId;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getAlertId() {
		return alertId;
	}

	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}
}