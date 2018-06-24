package com.tma.ats.api.service;

import com.tma.ats.api.dto.TheftDetectionCreationAttributes;
import com.tma.ats.api.dto.TheftDetectionModifiableAttributes;
import com.tma.ats.api.dto.TheftDetectionObject;

public interface TheftDetectionService {
	public TheftDetectionObject getTheftDetection(String deviceId);

	public TheftDetectionObject modifyTheftDetection(TheftDetectionModifiableAttributes theftDetection);

	public TheftDetectionObject createTheftDetection(TheftDetectionCreationAttributes attributes);
	
	public TheftDetectionObject setEnabledTheftDetection(String deviceId);
}