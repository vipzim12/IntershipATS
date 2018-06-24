package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface RouteObject extends BusinessObject<Long> {
	public String getName();
	
	public Double getLatitudeStart();

	public Double getLongitudeStart();
	
	public Double getLatitudeEnd();

	public Double getLongitudeEnd();
	
	public String getDescription();

	public RouteAreaObject getRouteArea();
}
