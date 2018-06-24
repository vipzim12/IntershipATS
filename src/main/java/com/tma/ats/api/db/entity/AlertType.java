package com.tma.ats.api.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;
import com.tma.ats.api.dto.AlertTypeObject;
import com.tma.ats.api.dto.AlertTypeObjectDTO;

@Entity
@Table(name = "alert_type")
public class AlertType extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private int stamp;
	
	@OneToMany(mappedBy="alertType")
	private List<TheftDetection> theftDetections;
	
	public AlertType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	
	public List<TheftDetection> getTheftDetections() {
		return theftDetections;
	}

	public void setTheftDetections(List<TheftDetection> theftDetections) {
		this.theftDetections = theftDetections;
	}
	
	public AlertTypeObject toAlertTypeObject() {
		return new AlertTypeObjectDTO(id, stamp, name, description);
	}
}
