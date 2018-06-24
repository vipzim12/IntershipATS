package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.RouteAreaCreationAttributes;
import com.tma.ats.api.dto.RouteAreaModifiableAttributes;
import com.tma.ats.api.dto.RouteAreaObject;

public interface RouteAreaService {
	public List<RouteAreaObject> getAllRouteAreas();
	
	public RouteAreaObject createRouteArea(RouteAreaCreationAttributes attributes);
	
	public RouteAreaObject modifyRouteArea(RouteAreaModifiableAttributes attributes);
	
	public void deleteRouteAreas(List<Long> objectId);
}