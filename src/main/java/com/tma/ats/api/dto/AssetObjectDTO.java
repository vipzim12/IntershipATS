package com.tma.ats.api.dto;

import com.tma.ats.api.db.entity.BatteryLevel;
import com.tma.ats.api.db.entity.DeviceStatus;

public class AssetObjectDTO implements AssetObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;

	private String identifier;
	private String serialNo;
	private String deviceId;
	private DeviceStatus deviceStatus;
	private BatteryLevel batteryLevel;
	private String product;
	private String description;
	private FleetObject fleet;

	/**
	 * IMPORTANT No-arg constructor is a MUST for GWT serializing/deserializing.
	 */
	public AssetObjectDTO() {
	}

	public AssetObjectDTO(Long objectId, int stamp, String identifier,
			String serialNo, String deviceId, DeviceStatus deviceStatus,
			BatteryLevel batteryLevel, String product, String description,
			FleetObject fleet) {
		super();
		this.objectId = objectId;
		this.stamp = stamp;
		this.identifier = identifier;
		this.serialNo = serialNo;
		this.deviceId = deviceId;
		this.deviceStatus = deviceStatus;
		this.batteryLevel = batteryLevel;
		this.product = product;
		this.description = description;
		this.fleet = fleet;
	}

	@Override
	public int getStamp() {
		return stamp;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getSerialNo() {
		return serialNo;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}

	@Override
	public BatteryLevel getBatteryLevel() {
		return batteryLevel;
	}

	@Override
	public String getProduct() {
		return product;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public FleetObject getFleetObject() {
		return fleet;
	}

	@Override
	public String toString() {
		return "AssetObjectDTO [objectId=" + objectId + ", stamp=" + stamp
				+ ", identifier=" + identifier + ", serialNo=" + serialNo
				+ ", deviceId=" + deviceId + ", deviceStatus=" + deviceStatus
				+ ", batteryLevel=" + batteryLevel + ", product=" + product
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((batteryLevel == null) ? 0 : batteryLevel.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result
				+ ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result
				+ ((objectId == null) ? 0 : objectId.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((serialNo == null) ? 0 : serialNo.hashCode());
		result = prime * result + stamp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetObjectDTO other = (AssetObjectDTO) obj;
		if (batteryLevel != other.batteryLevel)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceStatus != other.deviceStatus)
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (objectId == null) {
			if (other.objectId != null)
				return false;
		} else if (!objectId.equals(other.objectId))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (serialNo == null) {
			if (other.serialNo != null)
				return false;
		} else if (!serialNo.equals(other.serialNo))
			return false;
		if (stamp != other.stamp)
			return false;
		return true;
	}
}