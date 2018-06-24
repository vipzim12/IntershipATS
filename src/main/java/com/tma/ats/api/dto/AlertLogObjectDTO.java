package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.db.entity.EventType;

public class AlertLogObjectDTO implements AlertLogObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;

	private EventType eventType;
	private Date eventTime;
	private String message;
	private AlertObject alertObject;

	public AlertLogObjectDTO() {
	}

	public AlertLogObjectDTO(Long objectId, EventType eventType, Date eventTime,
			String message, AlertObject alertObject) {
		super();
		this.objectId = objectId;
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.message = message;
		this.alertObject = alertObject;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public int getStamp() {
		return 0;
	}
	
	@Override
	public EventType getEventType() {
		return eventType;
	}

	@Override
	public Date getEventTime() {
		return eventTime;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public AlertObject getAlertObject() {
		return alertObject;
	}

	@Override
	public String toString() {
		return eventTime + " - " + eventType + " : " + message + "\n";
	}
}
