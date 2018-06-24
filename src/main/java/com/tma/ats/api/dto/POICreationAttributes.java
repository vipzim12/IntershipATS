package com.tma.ats.api.dto;

import java.io.Serializable;

import com.tma.ats.api.core.VersionedObject;

public class POICreationAttributes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Double latitude;
	private Double longitude;
	private String description;
	private VersionedObject<Long> poiType;
	
	public POICreationAttributes(){}
	
	public POICreationAttributes(POIObject poiObject){
		this.name = poiObject.getName();
		this.latitude = poiObject.getLatitude();
		this.longitude = poiObject.getLongitude();
		this.description = poiObject.getDescription();
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
	
	public VersionedObject<Long> getPOIType() {
		return poiType;
	}

	public void setPOIType(VersionedObject<Long> poiType) {
		this.poiType = poiType;
	}
}
