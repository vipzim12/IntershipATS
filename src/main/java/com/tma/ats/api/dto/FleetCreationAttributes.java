package com.tma.ats.api.dto;

import java.io.Serializable;

public class FleetCreationAttributes implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	
	public FleetCreationAttributes() {
		super();
	}
	
	public FleetCreationAttributes(FleetObject object){
		super();
		setName(object.getName());
		setDescription(object.getDescription());
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
		builder.append("FleetCreationAttributes [name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
