package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.SafeAreaCreationAttributes;
import com.tma.ats.api.dto.SafeAreaModifiableAttributes;
import com.tma.ats.api.dto.SafeAreaObject;

public interface SafeAreaService {
	public List<SafeAreaObject> getSafeAreas(long theftDetectionId);
	
	public SafeAreaObject getSafeArea(long theftDetectionId);

	public SafeAreaObject modifySafeArea(SafeAreaModifiableAttributes safeArea);
	
	public SafeAreaObject createSafeArea(SafeAreaCreationAttributes attributes);
	
	public void deleteSafeArea(Long objectId);
	
	public SafeAreaObject getSafeRadiusOfAsset(String deviceId);
}
