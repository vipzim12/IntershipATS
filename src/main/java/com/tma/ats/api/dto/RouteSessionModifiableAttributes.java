package com.tma.ats.api.dto;

import java.io.Serializable;
import java.util.Date;

public class RouteSessionModifiableAttributes implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long objectId;
	private String name;
	private Date startTime;
	private Date endTime;
	private String description;
	private int stamp;
	private boolean completed;
	private double safeDistance;

	public RouteSessionModifiableAttributes(){}
	
	public RouteSessionModifiableAttributes(RouteSessionObject routeSessionObject){
		this.objectId = routeSessionObject.getObjectId();
		this.name = routeSessionObject.getName();
		this.startTime = routeSessionObject.getStartTime();
		this.endTime = routeSessionObject.getEndTime();
		this.description = routeSessionObject.getDescription();
		this.stamp = routeSessionObject.getStamp();
		this.completed = routeSessionObject.getCompleted();
		this.safeDistance = routeSessionObject.getSafeDistance();
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public double getSafeDistance() {
		return safeDistance;
	}

	public void setSafeDistance(double safeDistance) {
		this.safeDistance = safeDistance;
	}
}
