package com.tma.ats.api.dto;

import java.io.Serializable;

import com.tma.ats.api.core.VersionedObject;

public class RouteSessionCreationAttributes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private Double safeDistance;
	private VersionedObject<Long> route;
	
	public RouteSessionCreationAttributes(){}
	
	public RouteSessionCreationAttributes(RouteSessionObject routeSessionObject){
		this.name = routeSessionObject.getName();
		this.description = routeSessionObject.getDescription();
		this.safeDistance = routeSessionObject.getSafeDistance();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getSafeDistance() {
		return safeDistance;
	}

	public void setSafeDistance(Double safeDistance) {
		this.safeDistance = safeDistance;
	}

	public VersionedObject<Long> getRoute() {
		return route;
	}

	public void setRoute(VersionedObject<Long> route) {
		this.route = route;
	}
}