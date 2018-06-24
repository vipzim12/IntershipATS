package com.tma.ats.api.dto;

public class RoutePointObjectDTO implements RoutePointObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private Double latitude;
	private Double longitude;
	private RouteObject route;

	public RoutePointObjectDTO() {
	}

	public RoutePointObjectDTO(Long objectId, int stamp,
			Double latitude, Double longitude,RouteObject route) {
		this.objectId = objectId;
		this.stamp = stamp;
		this.latitude = latitude;
		this.longitude = longitude;
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
	public Double getLatitude() {
		return latitude;
	}

	@Override
	public Double getLongitude() {
		return longitude;
	}

	 @Override
	 public RouteObject getRoute() {
		 return route;
	 }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoutePointObjectDTO [objectId=");
		builder.append(objectId);
		builder.append(", stamp=");
		builder.append(stamp);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", route=");
		builder.append(route);
		builder.append("]");
		return builder.toString();
	}
}
