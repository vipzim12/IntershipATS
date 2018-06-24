package com.tma.ats.api.db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;

@Entity
@Table(name = "route")
public class Route extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Column(name = "latitude_start")
	private Double latitudeStart;
	
	@Column(name = "longitude_start")
	private Double longitudeStart;
	
	@Column(name = "latitude_end")
	private Double latitudeEnd;
	
	@Column(name = "longitude_end")
	private Double longitudeEnd;
	
	private String description;

	private int stamp;
	
	@ManyToOne
	@JoinColumn(name = "route_area")
	private RouteArea routeArea;
	
	@OneToMany(mappedBy="route")
	private List<RoutePoint> routePoints;
	
	@OneToMany(mappedBy="route")
	private List<RouteSession> routeSessions;

	public Route() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitudeStart() {
		return latitudeStart;
	}

	public void setLatitudeStart(Double latitudeStart) {
		this.latitudeStart = latitudeStart;
	}

	public Double getLongitudeStart() {
		return longitudeStart;
	}

	public void setLongitudeStart(Double longitudeStart) {
		this.longitudeStart = longitudeStart;
	}

	public Double getLatitudeEnd() {
		return latitudeEnd;
	}

	public void setLatitudeEnd(Double latitudeEnd) {
		this.latitudeEnd = latitudeEnd;
	}

	public Double getLongitudeEnd() {
		return longitudeEnd;
	}

	public void setLongitudeEnd(Double longitudeEnd) {
		this.longitudeEnd = longitudeEnd;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RouteArea getRouteArea() {
		return routeArea;
	}

	public void setRouteArea(RouteArea routeArea) {
		this.routeArea = routeArea;
	}
	
    public List<RoutePoint> getRoutePoints() {
		return routePoints;
	}

	public void setRoutePoints(List<RoutePoint> routePoints) {
		this.routePoints = routePoints;
	}
	
    public List<RouteSession> getRouteSessions() {
		return routeSessions;
	}

	public void setRouteSessions(List<RouteSession> routeSessions) {
		this.routeSessions = routeSessions;
	}
}