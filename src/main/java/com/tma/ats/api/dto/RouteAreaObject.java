package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;

public interface RouteAreaObject extends BusinessObject<Long> {
	public String getName();

	public String getDescription();
}
