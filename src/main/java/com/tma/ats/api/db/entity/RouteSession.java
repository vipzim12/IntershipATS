package com.tma.ats.api.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;

@Entity
@Table(name = "route_session")
public class RouteSession extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private int stamp;
	private boolean completed;
	private Date startTime;
	private Date endTime;
	private Double safeDistance;
	
	@ManyToOne
	@JoinColumn(name = "route")
	private Route route;
	
	@ManyToMany
	@JoinTable(name = "asset_routesession", joinColumns = { @JoinColumn(name = "route_session_id") }, inverseJoinColumns = { @JoinColumn(name = "asset_id") })
	private List<Asset> assets;

	public RouteSession() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getSafeDistance() {
		return safeDistance;
	}

	public void setSafeDistance(Double safeDistance) {
		this.safeDistance = safeDistance;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	public List<Asset> getAssets() {
		return this.assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

}