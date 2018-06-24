package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.PositionCreationAttributes;
import com.tma.ats.api.dto.PositionObject;

public interface PositionService {
	public List<PositionObject> getAllPositions();

	public PositionObject getPositionByDeviceId(String deviceId);
	
	public List<PositionObject> getPositionsByDeviceId(String deviceId);
	
	public PositionObject createPosition(PositionCreationAttributes attributes);
	
	public List<PositionObject> getPositionsByDeviceIds(List<String> deviceIds);
}