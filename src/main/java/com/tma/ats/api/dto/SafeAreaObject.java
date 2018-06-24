package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface SafeAreaObject extends BusinessObject<Long> {
	
	public TheftDetectionObject getTheftDetectionObject();	
	
	public String getName();
	
	public double getLatitude();
	
	public double getLongitude();
	
	public double getRadius();
	
	public boolean getEnabled();
	
	public String getDescription();
}
