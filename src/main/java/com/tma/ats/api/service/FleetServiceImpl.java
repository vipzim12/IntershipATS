package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.FleetConverter;
import com.tma.ats.api.db.dao.FleetDao;
import com.tma.ats.api.db.entity.Fleet;
import com.tma.ats.api.dto.FleetCreationAttributes;
import com.tma.ats.api.dto.FleetModifiableAttributes;
import com.tma.ats.api.dto.FleetObject;

@Service
public class FleetServiceImpl implements FleetService {

	@Autowired
	private FleetDao fleetDao;

	private FleetConverter fleetConverter = new FleetConverter();

	@Override
	public List<FleetObject> getAllFleets() {
		List<Fleet> fleets = fleetDao.list();
		List<FleetObject> results = new ArrayList<FleetObject>();
		if (fleets != null) {
			for (Fleet fleet : fleets) {
				results.add(fleetConverter.convert(fleet));
			}
		}
		return results;
	}

	@Override
	public FleetObject getFleetById(Long objectId) {
		Fleet fleet = fleetDao.read(objectId);
		return fleetConverter.convert(fleet);
	}

	@Override
	public FleetObject createFleet(FleetCreationAttributes attributes) {
		Fleet fleet = new Fleet();
		fleet.setName(attributes.getName());
		fleet.setDescription(attributes.getDescription());
		fleet.setStamp(0);
		fleet = fleetDao.create(fleet);
		return fleetConverter.convert(fleet);
	}

	@Override
	public FleetObject modifyFleet(FleetModifiableAttributes attributes) {
		Fleet fleet = fleetDao.read(attributes.getObjectId());
		fleet.setName(attributes.getName());
		fleet.setDescription(attributes.getDescription());
		fleet.setStamp(attributes.getStamp() + 1);
		fleet = fleetDao.update(fleet);
		return fleetConverter.convert(fleet);
	}

}
