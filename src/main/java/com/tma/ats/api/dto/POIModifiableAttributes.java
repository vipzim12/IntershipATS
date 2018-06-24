package com.tma.ats.api.dto;

import java.io.Serializable;

public class POIModifiableAttributes implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long objectId;
	private String name;
	private Double latitude;
	private Double longitude;
	private String description;
	private int stamp;
	
	public POIModifiableAttributes(){}
	
	public POIModifiableAttributes(POIObject poiObject){
		this.objectId = poiObject.getObjectId();
		this.name = poiObject.getName();
		this.latitude = poiObject.getLatitude();
		this.longitude = poiObject.getLongitude();
		this.description = poiObject.getDescription();
		this.stamp = poiObject.getStamp();
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
}