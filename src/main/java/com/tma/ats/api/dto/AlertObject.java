package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.core.BusinessObject;
import com.tma.ats.api.db.entity.AlertAckState;

public interface AlertObject extends BusinessObject<Long> {
	public String getDeviceId();
	
	public AlertAckState getAlertAckState();
	
	public Date getRaisedTime();
	
	public String getAcknowledgedBy();
	
	public boolean getResolved();
	
	public Date getResolveTime();
	
	public String getResolveMessage();
	
	public AlertTypeObject getAlertTypeObject();
	
	public AlertStatusObject getAlertStatusObject();
}
