package com.tma.ats.api.dto;

import java.io.Serializable;

public class AssetCreationAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private String serialNo;
	private String description;
	private String identifier;
	private String deviceId;
	private String product;
	private FleetObject fleet;

	public AssetCreationAttributes() {
	}

	public AssetCreationAttributes(AssetObject assetObject) {
		this.serialNo = assetObject.getSerialNo();
		this.description = assetObject.getDescription();
		this.identifier = assetObject.getIdentifier();
		this.deviceId = assetObject.getDeviceId();
		this.product = assetObject.getProduct();
		this.fleet = assetObject.getFleetObject();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	public FleetObject getFleet() {
		return fleet;
	}

	public void setFleet(FleetObject fleet) {
		this.fleet = fleet;
	}
}