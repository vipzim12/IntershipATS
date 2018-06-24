package com.tma.ats.api.dto;

import java.io.Serializable;

import com.tma.ats.api.core.VersionedObject;

public class RouteCreationAttributes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Double latitudeStart;
	private Double longitudeStart;
	private Double latitudeEnd;
	private Double longitudeEnd;
	private String description;
	private VersionedObject<Long> routeArea;
	
	public RouteCreationAttributes(){}
	
	public RouteCreationAttributes(RouteObject routeObject){
		this.name = routeObject.getName();
		this.latitudeStart = routeObject.getLatitudeStart();
		this.longitudeStart = routeObject.getLongitudeStart();
		this.latitudeEnd = routeObject.getLatitudeEnd();
		this.longitudeEnd = routeObject.getLongitudeEnd();
		this.description = routeObject.getDescription();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitudeStart() {
		return latitudeStart;
	}

	public void setLatitudeStart(Double latitudeStart) {
		this.latitudeStart = latitudeStart;
	}

	public Double getLongitudeStart() {
		return longitudeStart;
	}

	public void setLongitudeStart(Double longitudeStart) {
		this.longitudeStart = longitudeStart;
	}
	
	public Double getLatitudeEnd() {
		return latitudeEnd;
	}

	public void setLatitudeEnd(Double latitudeEnd) {
		this.latitudeEnd = latitudeEnd;
	}

	public Double getLongitudeEnd() {
		return longitudeEnd;
	}

	public void setLongitudeEnd(Double longitudeEnd) {
		this.longitudeEnd = longitudeEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public VersionedObject<Long> getRouteArea() {
		return routeArea;
	}

	public void setRouteArea(VersionedObject<Long> routeArea) {
		this.routeArea = routeArea;
	}
}
