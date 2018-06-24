package com.tma.ats.api.dto;

import java.io.Serializable;

public class SafeAreaCreationAttributes implements Serializable {
	private static final long serialVersionUID = 1L;

	private TheftDetectionObject theftDetection;
	private String name;
	private boolean enabled;
	private double latitude;
	private double longitude;
	private double radius;
	private String description;

	public SafeAreaCreationAttributes() {
	}

	public SafeAreaCreationAttributes(TheftDetectionObject theftDetection,
			String name, boolean enabled, double latitude, double longitude,
			double radius, String description) {
		this.theftDetection = theftDetection;
		this.name = name;
		this.enabled = enabled;
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		this.description = description;
	}

	public TheftDetectionObject getTheftDetection() {
		return theftDetection;
	}

	public void setTheftDetection(TheftDetectionObject theftDetection) {
		this.theftDetection = theftDetection;
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
	
	@Override
	public String toString() {
		return "SafeAreaObjectDTO [theftDetection=" + theftDetection + ", name=" + name
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", radius=" + radius + ", enabled=" + enabled
				+ ", description=" + description + "]";
	}
}