package com.tma.ats.api.db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;

@Entity
@Table(name = "asset")
public class Asset extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String identifier;

	@Column(name = "serial_no")
	private String serialNo;

	@Column(name = "device_id")
	private String deviceId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private DeviceStatus deviceStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = "battery_level")
	private BatteryLevel batteryLevel;

	private String product;

	private int stamp;
	
	@Column(name = "last_position")
	private long lastPositionId;
	
	@ManyToMany(mappedBy = "assets")
	private List<RouteSession> routeSessions;
	
	@ManyToOne
	@JoinColumn(name = "fleet")
	private Fleet fleet;

	public Asset() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getStamp() {
		return this.stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public long getLastPositionId() {
		return lastPositionId;
	}

	public void setLastPositionId(long lastPositionId) {
		this.lastPositionId = lastPositionId;
	}

	public List<RouteSession> getRouteSessions() {
		return this.routeSessions;
	}

	public void setRouteSessions(List<RouteSession> routeSessions) {
		this.routeSessions = routeSessions;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", description=" + description
				+ ", identifier=" + identifier + ", device_Id=" + deviceId
				+ ", product=" + product + ", serial_No=" + serialNo + "]";
	}

	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public BatteryLevel getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(BatteryLevel batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	
	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}
}