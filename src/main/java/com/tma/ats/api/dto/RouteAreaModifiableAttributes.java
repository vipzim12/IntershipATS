package com.tma.ats.api.dto;

import java.io.Serializable;

public class RouteAreaModifiableAttributes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long objectId;
	private int stamp;
	private String name;
	private String description;
	
	public RouteAreaModifiableAttributes() {
		super();
	}

	public RouteAreaModifiableAttributes(RouteAreaObject department) {
		super();
		this.objectId = department.getObjectId();
		this.stamp = department.getStamp();
		this.name = department.getName();
		this.description = department.getDescription();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteAreaModifiableAttributes [objectId=");
		builder.append(objectId);
		builder.append(", stamp=");
		builder.append(stamp);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
