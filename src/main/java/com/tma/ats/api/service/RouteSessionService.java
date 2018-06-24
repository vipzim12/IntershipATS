package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.AssetObject;
import com.tma.ats.api.dto.RouteSessionCreationAttributes;
import com.tma.ats.api.dto.RouteSessionModifiableAttributes;
import com.tma.ats.api.dto.RouteSessionObject;

public interface RouteSessionService {
	public List<RouteSessionObject> getRouteSessionsByRoute(Long objectId);
	
	public RouteSessionObject getRouteSession(long objectId);
	
	public List<AssetObject> getAssetsByRouteSession(Long objectId);
	
	public RouteSessionObject createRouteSession(RouteSessionCreationAttributes attributes);
	
	void addAssetsToRouteSession(Long routeSessionId, List<Long> assetIds);
	
	void removeAssetsFromRouteSession(Long routeSessionId, List<Long> assetIds);
	
	public RouteSessionObject changeStateRouteSession(RouteSessionModifiableAttributes attributes);
}