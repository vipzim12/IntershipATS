package com.tma.ats.api.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;
import com.tma.ats.api.dto.PositionObject;
import com.tma.ats.api.dto.PositionObjectDto;

@Entity
@Table(name = "position")
public class Position extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "device_id")
	private String deviceId;

	private Double latitude;

	private Double longitude;

	private Integer speed;

	private Date receivedTime;

	private Date reportedTime;

	public Position() {

	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getSpeed() {
		return this.speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Date getReceivedTime() {
		return this.receivedTime;
	}

	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}

	public Date getReportedTime() {
		return this.reportedTime;
	}

	public void setReportedTime(Date reportedTime) {
		this.reportedTime = reportedTime;
	}

	public PositionObject toPositionObject() {
		return new PositionObjectDto(id, deviceId, latitude, longitude, speed,
				receivedTime, reportedTime);
	}
}