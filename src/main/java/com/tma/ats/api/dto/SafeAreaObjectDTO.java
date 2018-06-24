package com.tma.ats.api.dto;

public class SafeAreaObjectDTO implements SafeAreaObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;

	private TheftDetectionObject theftDetection;
	private String name;
	private double latitude;
	private double longitude;
	private double radius;
	private boolean enabled;
	private String description;

	/**
	 * IMPORTANT No-arg constructor is a MUST for GWT serializing/deserializing.
	 */
	public SafeAreaObjectDTO() {
	}

	public SafeAreaObjectDTO(Long objectId, int stamp,
			TheftDetectionObject theftDetection, String name, double latitude,
			double longitude, double radius, boolean enabled, String description) {
		super();
		this.objectId = objectId;
		this.stamp = stamp;
		this.name = name;
		this.theftDetection = theftDetection;
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		this.enabled = enabled;
		this.description = description;
	}

	@Override
	public int getStamp() {
		return stamp;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public TheftDetectionObject getTheftDetectionObject() {
		return theftDetection;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public boolean getEnabled() {
		return enabled;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "SafeAreaObjectDTO [objectId=" + objectId + ", stamp=" + stamp
				+ ", theftDetection=" + theftDetection + ", name=" + name
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", radius=" + radius + ", enabled=" + enabled
				+ ", description=" + description + "]";
	}
}
