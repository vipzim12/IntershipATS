package com.tma.ats.api.dto;

import java.io.Serializable;

public class SafeAreaModifiableAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private String name;
	private boolean enabled;
	private double latitude;
	private double longitude;
	private double radius;
	private String description;

	public SafeAreaModifiableAttributes() {
	}

	public SafeAreaModifiableAttributes(SafeAreaObject safeArea) {
		this.objectId = safeArea.getObjectId();
		this.stamp = safeArea.getStamp();
		this.name = safeArea.getName();
		this.enabled = safeArea.getEnabled();
		this.latitude = safeArea.getLatitude();
		this.longitude = safeArea.getLongitude();
		this.radius = safeArea.getRadius();
		this.description = safeArea.getDescription();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}