package com.tma.ats.api.dto;

import java.io.Serializable;

public class RoutePointModifiableAttributes implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long objectId;
	private Double latitude;
	private Double longitude;
	private int stamp;
	
	public RoutePointModifiableAttributes(){}
	
	public RoutePointModifiableAttributes(RoutePointObject routeObject){
		this.objectId = routeObject.getObjectId();
		this.latitude = routeObject.getLatitude();
		this.longitude = routeObject.getLongitude();
		this.stamp = routeObject.getStamp();
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
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

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
}