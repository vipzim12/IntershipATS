package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface AlertStatusObject extends BusinessObject<Long> {
	
	public AlertTypeObject getAlertTypeObject();
	
	public String getStatus();
}
