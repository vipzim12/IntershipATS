package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface RoutePointObject extends BusinessObject<Long> {
	public Double getLatitude();

	public Double getLongitude();

	public RouteObject getRoute();
}
