package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface RouteLatLngObject extends BusinessObject<Long> {
	public Double getLatitude();

	public Double getLongitude();
}
