package com.tma.ats.api.dto;

import java.io.Serializable;

import com.tma.ats.api.core.VersionedObject;

public class RoutePointCreationAttributes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Double latitude;
	private Double longitude;
	private VersionedObject<Long> route;
	
	public RoutePointCreationAttributes(){}
	
	public RoutePointCreationAttributes(double latiude, double longitude){
		this.latitude = latiude;
		this.longitude = longitude;
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

	public VersionedObject<Long> getRoute() {
		return route;
	}

	public void setRoute(VersionedObject<Long> route) {
		this.route = route;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoutePointCreationAttributes [latitude=");
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}
}