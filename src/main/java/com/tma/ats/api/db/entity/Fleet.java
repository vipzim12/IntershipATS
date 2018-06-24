package com.tma.ats.api.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;
import com.tma.ats.api.dto.FleetObject;
import com.tma.ats.api.dto.FleetObjectDTO;

@Entity
@Table(name="fleet")
public class Fleet extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;
	private String name;
	private int stamp;

	@OneToMany(mappedBy="fleet")
	private List<Asset> assets;

	public Fleet() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStamp() {
		return this.stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	
    public List<Asset> getAssets() {
		return assets;
	}

	public void setRoutes(List<Asset> assets) {
		this.assets = assets;
	}
	
	public FleetObject toFleetObject() {
		return new FleetObjectDTO(id, stamp, name, description);
	}
	
}