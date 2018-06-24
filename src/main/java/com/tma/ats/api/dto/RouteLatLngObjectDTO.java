package com.tma.ats.api.dto;

public class RouteLatLngObjectDTO implements RouteLatLngObject {
	private static final long serialVersionUID = 1L;

	private Double latitude;
	private Double longitude;

	public RouteLatLngObjectDTO() {
	}

	public RouteLatLngObjectDTO(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public int getStamp() {
		return 0;
	}

	@Override
	public Long getObjectId() {
		return (long) -1;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteLatLngObjectDTO [");
		builder.append("latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append("]");
		return builder.toString();
	}
}
