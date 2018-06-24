package com.tma.ats.api.dto;

public class POIObjectDTO implements POIObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private String name;
	private Double latitude;
	private Double longitude;
	private String description;
	private POITypeObject poiType;

	public POIObjectDTO() {
		super();
	}

	public POIObjectDTO(Long objectId, int stamp, String name, Double latitude,
			Double longitude, String description, POITypeObject poiType) {
		this.objectId = objectId;
		this.stamp = stamp;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.poiType = poiType;
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
	public Double getLatitude() {
		return latitude;
	}

	@Override
	public Double getLongitude() {
		return longitude;
	}

	@Override
	public String getDescription() {
		return description;
	}

	 @Override
	 public POITypeObject getPOIType() {
	 return poiType;
	 }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("POIObjectDTO [objectId=");
		builder.append(objectId);
		builder.append(", stamp=");
		builder.append(stamp);
		builder.append(", name=");
		builder.append(name);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", description=");
		builder.append(description);
		builder.append(", poiType=");
		builder.append(poiType);
		builder.append("]");
		return builder.toString();
	}
}
