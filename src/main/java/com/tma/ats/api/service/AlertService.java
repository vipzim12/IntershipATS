package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.AlertModifiableAttributes;
import com.tma.ats.api.dto.AlertObject;
import com.tma.ats.api.dto.AssetInTroubleObject;
import com.tma.ats.api.dto.UiAlertTypeObject;

public interface AlertService {
	public List<AlertObject> getAllAlerts();
	
	public List<AlertObject> getAlertsByType(long id);
	
	public List<UiAlertTypeObject> getAlertsTypeOfAlert(AssetInTroubleObject assetInTrouble);
	
	public AlertObject resolveAlert(AlertModifiableAttributes attr);
	
	public AlertObject acknowledgeAlert(AlertModifiableAttributes attr);
	
	public AlertObject createAlertByTheftDetection(String deviceId);
	
	public AlertObject createAlertByOutOfRoute(String deviceId);
}
