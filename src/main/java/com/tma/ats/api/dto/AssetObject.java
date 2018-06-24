package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;
import com.tma.ats.api.db.entity.BatteryLevel;
import com.tma.ats.api.db.entity.DeviceStatus;

public interface AssetObject extends BusinessObject<Long> {
	public FleetObject getFleetObject();	
	
	public String getIdentifier();

	public String getSerialNo();

	public String getDeviceId();

	public DeviceStatus getDeviceStatus();

	public BatteryLevel getBatteryLevel();

	public String getProduct();

	public String getDescription();
}
