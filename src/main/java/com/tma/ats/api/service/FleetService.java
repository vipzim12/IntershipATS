package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.FleetCreationAttributes;
import com.tma.ats.api.dto.FleetModifiableAttributes;
import com.tma.ats.api.dto.FleetObject;

public interface FleetService {
	public List<FleetObject> getAllFleets();
	
	public FleetObject getFleetById(Long objectId);
	
	public FleetObject createFleet(FleetCreationAttributes attributes);
	
	public FleetObject modifyFleet(FleetModifiableAttributes attributes);
}