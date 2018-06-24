package com.tma.ats.api.dto;

public class POITypeObjectDTO implements POITypeObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;
	private int stamp;
	private String name;
	private String description;
	
	public POITypeObjectDTO(){
		super();
	}
	
	public POITypeObjectDTO(Long objectId, int stamp, String name, String description) {
		super();
		this.objectId = objectId;
		this.stamp = stamp;
		this.name = name;
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
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
