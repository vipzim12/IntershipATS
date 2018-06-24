package com.tma.ats.api.service;

import com.tma.ats.api.dto.IdleDetectionCreationAttributes;
import com.tma.ats.api.dto.IdleDetectionModifiableAttributes;
import com.tma.ats.api.dto.IdleDetectionObject;

public interface IdleDetectionService {
	public IdleDetectionObject getIdleDetection(String deviceId);

	public IdleDetectionObject modifyIdleDetection(IdleDetectionModifiableAttributes attributes);

	public IdleDetectionObject createIdleDetection(IdleDetectionCreationAttributes attributes);
	
	public IdleDetectionObject setEnabledIdleDetection(Long id);
}