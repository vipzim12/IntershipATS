package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.AlertLogCreationAttributes;
import com.tma.ats.api.dto.AlertLogObject;

public interface AlertLogService {
	public AlertLogObject createAlertLog(AlertLogCreationAttributes attributes);
	
	public List<AlertLogObject> getAlertLogs(long alertId);
}