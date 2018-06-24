package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.core.BusinessObject;
import com.tma.ats.api.db.entity.EventType;

public interface AlertLogObject extends BusinessObject<Long> {
	public EventType getEventType();
	
	public Date getEventTime();

	public String getMessage();

	public AlertObject getAlertObject();
}
