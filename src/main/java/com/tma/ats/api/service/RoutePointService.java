package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.RoutePointCreationAttributes;
import com.tma.ats.api.dto.RoutePointObject;

public interface RoutePointService {
	public List<RoutePointObject> getRoutePointsByRoute(Long objectId);
	
	public List<RoutePointObject> createRoutePoint(List<RoutePointCreationAttributes> attributes);
}
