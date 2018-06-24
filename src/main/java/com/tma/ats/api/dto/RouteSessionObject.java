package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.core.BusinessObject;

public interface RouteSessionObject extends BusinessObject<Long> {

	public String getName();
	
	public String getDescription();

	public boolean getCompleted();

	public Date getStartTime();

	public Date getEndTime();
	
	public Double getSafeDistance();

	public RouteObject getRoute();
}
