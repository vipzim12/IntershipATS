package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface POIObject extends BusinessObject<Long> {
	public String getName();
	
	public Double getLatitude();

	public Double getLongitude();
	
	public String getDescription();

	public POITypeObject getPOIType();
}
