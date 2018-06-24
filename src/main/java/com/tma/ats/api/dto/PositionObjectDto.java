package com.tma.ats.api.dto;

import java.util.Date;

public class PositionObjectDto implements PositionObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private String deviceId;
	private Double latitude;
	private Double longitude;
	private Integer speed;
	private Date receivedTime;
	private Date reportedTime;

	public PositionObjectDto() {

	}

	public PositionObjectDto(Long objectId, String deviceId, Double latitude,
			Double longitude, Integer speed, Date receivedTime,
			Date reportedTime) {
		super();
		this.objectId = objectId;
		this.deviceId = deviceId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.receivedTime = receivedTime;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public Double getLatitude() {
		return latitude;
	}

	@Override
	public Double getLongitude() {
		return longitude;
	}

	@Override
	public Integer getSpeed() {
		return speed;
	}

	@Override
	public Date getReceivedTime() {
		return receivedTime;
	}

	@Override
	public Date getReportedTime() {
		return reportedTime;
	}

	@Override
	public int getStamp() {
		return 0;
	}
}
