package com.tma.ats.api.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;
import com.tma.ats.api.dto.SafeAreaObject;
import com.tma.ats.api.dto.SafeAreaObjectDTO;

@Entity
@Table(name = "safe_area")
public class SafeArea extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "theft_detection_id")
	private TheftDetection theftDetection;

	private String name;
	private Double latitude;
	private Double longitude;
	private Double radius;
	private boolean enabled;
	private String description;
	private int stamp;

	public SafeArea() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public TheftDetection getTheftDetection() {
		return theftDetection;
	}

	public void setTheftDetection(TheftDetection theftDetection) {
		this.theftDetection = theftDetection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public SafeAreaObject toSafeAreaObject() {
		return new SafeAreaObjectDTO(id, stamp,
				theftDetection.toTheftDetectionObject(), name, latitude,
				longitude, radius, enabled, description);
	}

}