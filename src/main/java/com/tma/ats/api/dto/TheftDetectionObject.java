package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface TheftDetectionObject extends BusinessObject<Long> {
	public String getDeviceId();

	public String getMessage();
	
	public String getMail();
	
	public int getPriority();
	
	public boolean getEnabled();
	
	public AlertTypeObject getAlertTypeObject();
}
