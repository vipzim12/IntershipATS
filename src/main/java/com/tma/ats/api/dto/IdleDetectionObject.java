package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface IdleDetectionObject extends BusinessObject<Long> {
	public String getDeviceId();

	public String getMessage();
	
	public String getMail();
	
	public int getPriority();
	
	public boolean isEnable();
	
	public double getRaidus();
	
	public Double getDuration();
	
	public AlertTypeObject getAlertTypeObject();
}
