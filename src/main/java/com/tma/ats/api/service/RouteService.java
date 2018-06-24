package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.RouteCreationAttributes;
import com.tma.ats.api.dto.RouteObject;

public interface RouteService {
	public List<RouteObject> getRoutesByArea(Long objectId);
	
	public List<RouteObject> getAllRoutes();
	
	public RouteObject createRoute(RouteCreationAttributes attributes);
	
	public RouteObject getRoute(long objectId);
	
	public void deleteRoutes(List<Long> objectIds);
}
