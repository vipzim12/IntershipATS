package com.tma.ats.api.dto;

import java.util.Date;

public class RouteSessionObjectDTO implements RouteSessionObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	
	private int stamp;
	private String name;
	private String description;
	private boolean completed;
	private Date startTime;
	private Date endTime;
	private Double safeDistance;
	private RouteObject route;

	public RouteSessionObjectDTO() {
	}

	public RouteSessionObjectDTO(Long objectId, int stamp, String name,
			String description, boolean completed, Date startTime, Date endTime,
			Double safeDistance, RouteObject route) {
		this.objectId = objectId;
		this.stamp = stamp;
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.startTime = startTime;
		this.endTime = endTime;
		this.safeDistance = safeDistance;
		this.route = route;
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
	 public RouteObject getRoute() {
		 return route;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean getCompleted() {
		return completed;
	}

	@Override
	public Date getStartTime() {
		return startTime;
	}

	@Override
	public Date getEndTime() {
		return endTime;
	}
	
	@Override
	public Double getSafeDistance() {
		return safeDistance;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteSessionObjectDTO [objectId=");
		builder.append(objectId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", completed=");
		builder.append(completed);
		builder.append(", safeDistance=");
		builder.append(safeDistance);
		builder.append(", route=");
		builder.append(route);
		builder.append("]");
		return builder.toString();
	}
}
