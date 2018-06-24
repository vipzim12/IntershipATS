package com.tma.ats.api.dto;

import java.util.Date;

import com.tma.ats.api.core.BusinessObject;

public interface PositionObject extends BusinessObject<Long> {
	public String getDeviceId();

	public Double getLatitude();

	public Double getLongitude();

	public Integer getSpeed();

	public Date getReceivedTime();

	public Date getReportedTime();
}
