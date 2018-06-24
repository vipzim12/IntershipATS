package com.tma.ats.api.dto;

public class RouteObjectDTO implements RouteObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private String name;
	private Double latitudeStart;
	private Double longitudeStart;
	private Double latitudeEnd;
	private Double longitudeEnd;
	private String description;
	private RouteAreaObject routeArea;

	public RouteObjectDTO() {
	}

	public RouteObjectDTO(Long objectId, int stamp, String name,
			Double latitudeStart, Double longitudeStart, Double latitudeEnd,
			Double longitudeEnd, String description, RouteAreaObject routeArea) {
		this.objectId = objectId;
		this.stamp = stamp;
		this.name = name;
		this.latitudeStart = latitudeStart;
		this.longitudeStart = longitudeStart;
		this.latitudeEnd = latitudeEnd;
		this.longitudeEnd = longitudeEnd;
		this.description = description;
		this.routeArea = routeArea;
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
	public String getName() {
		return name;
	}

	@Override
	public Double getLatitudeStart() {
		return latitudeStart;
	}

	@Override
	public Double getLongitudeStart() {
		return longitudeStart;
	}

	@Override
	public Double getLatitudeEnd() {
		return latitudeEnd;
	}

	@Override
	public Double getLongitudeEnd() {
		return longitudeEnd;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	 @Override
	 public RouteAreaObject getRouteArea() {
		 return routeArea;
	 }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteObjectDTO [objectId=");
		builder.append(objectId);
		builder.append(", stamp=");
		builder.append(stamp);
		builder.append(", name=");
		builder.append(name);
		builder.append(", latitudeStart=");
		builder.append(latitudeStart);
		builder.append(", longitudeStart=");
		builder.append(longitudeStart);
		builder.append(", latitudeEnd=");
		builder.append(latitudeEnd);
		builder.append(", longitudeEnd=");
		builder.append(longitudeEnd);
		builder.append(", description=");
		builder.append(description);
		builder.append(", routeArea=");
		builder.append(routeArea);
		builder.append("]");
		return builder.toString();
	}
}