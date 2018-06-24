package com.tma.ats.api.dto;

import java.io.Serializable;

public class PositionCreationAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private double latitude;
	private double longitude;
	private String deviceId;

	public PositionCreationAttributes() {
	}

	public PositionCreationAttributes(PositionObject positionObject) {
		this.latitude = positionObject.getLatitude();
		this.longitude = positionObject.getLongitude();
		this.deviceId = positionObject.getDeviceId();
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}