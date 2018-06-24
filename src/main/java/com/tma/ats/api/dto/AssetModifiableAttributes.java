package com.tma.ats.api.dto;

import java.io.Serializable;

public class AssetModifiableAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private String identifier;
	private String serialNo;
	private String description;
	private String deviceId;
	private String product;

	public AssetModifiableAttributes() {
	}

	public AssetModifiableAttributes(AssetObject assetObject) {
		this.objectId = assetObject.getObjectId();
		this.identifier = assetObject.getIdentifier();
		this.stamp = assetObject.getStamp();
		this.serialNo = assetObject.getSerialNo();
		this.description = assetObject.getDescription();
		this.deviceId = assetObject.getDeviceId();
		this.product = assetObject.getProduct();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
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
}