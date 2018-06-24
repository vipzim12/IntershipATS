package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.SafeAreaDao;
import com.tma.ats.api.db.dao.TheftDetectionDao;
import com.tma.ats.api.db.entity.SafeArea;
import com.tma.ats.api.db.entity.TheftDetection;
import com.tma.ats.api.dto.SafeAreaCreationAttributes;
import com.tma.ats.api.dto.SafeAreaModifiableAttributes;
import com.tma.ats.api.dto.SafeAreaObject;
import com.tma.ats.api.dto.SafeAreaObjectDTO;

@Service
public class SafeAreaServiceImpl implements SafeAreaService {

	@Autowired
	private SafeAreaDao safeAreaDao;
	@Autowired
	private TheftDetectionDao theftDetectionDao;

	@Override
	public List<SafeAreaObject> getSafeAreas(long theftDetectionId) {
		List<SafeArea> safeAreas = safeAreaDao.getSafeAreas(theftDetectionId);
		if (safeAreas == null) {
			return null;
		}
		List<SafeAreaObject> safeAreaObjects = new ArrayList<SafeAreaObject>();
		for (SafeArea safeArea : safeAreas) {
			safeAreaObjects.add(safeArea.toSafeAreaObject());
		}
		return safeAreaObjects;
	}

	@Override
	public SafeAreaObject getSafeArea(long theftDetectionId) {
		SafeArea safeArea = safeAreaDao.read(theftDetectionId);
		if (safeArea == null) {
			return null;
		}
		return safeArea.toSafeAreaObject();
	}

	@Override
	public SafeAreaObject modifySafeArea(SafeAreaModifiableAttributes attributes) {
		SafeArea safeArea = safeAreaDao.read(attributes.getObjectId());

		if (safeArea.getStamp() != attributes.getStamp()) {
			return null;
		}

		safeArea.setName(attributes.getName());
		safeArea.setEnabled(attributes.isEnabled());
		safeArea.setLatitude(attributes.getLatitude());
		safeArea.setLongitude(attributes.getLongitude());
		safeArea.setRadius(attributes.getRadius());
		safeArea.setDescription(attributes.getDescription());
		safeArea.setStamp(attributes.getStamp() + 1);
		safeArea = safeAreaDao.update(safeArea);

		SafeAreaObject safeAreaObject = new SafeAreaObjectDTO(safeArea.getId(), safeArea.getStamp(),
				safeArea.getTheftDetection().toTheftDetectionObject(), safeArea.getName(), safeArea.getLatitude(),
				safeArea.getLongitude(), safeArea.getRadius(), safeArea.isEnabled(), safeArea.getDescription());

		return safeAreaObject;
	}

	@Override
	public SafeAreaObject createSafeArea(SafeAreaCreationAttributes attributes) {
		SafeArea safeArea = new SafeArea();

		TheftDetection theftDetection = theftDetectionDao.read(attributes.getTheftDetection().getObjectId());

		safeArea.setTheftDetection(theftDetection);
		safeArea.setName(attributes.getName());
		safeArea.setEnabled(attributes.isEnabled());
		safeArea.setLatitude(attributes.getLatitude());
		safeArea.setLongitude(attributes.getLongitude());
		safeArea.setRadius(attributes.getRadius());
		safeArea.setDescription(attributes.getDescription());
		safeArea.setStamp(0);

		safeArea = safeAreaDao.create(safeArea);

		return safeArea.toSafeAreaObject();
	}

	@Override
	public void deleteSafeArea(Long objectId) {
		SafeArea safeArea = safeAreaDao.read(objectId);
		if (safeArea != null) {
			safeAreaDao.delete(safeArea);
		}
	}

	@Override
	public SafeAreaObject getSafeRadiusOfAsset(String deviceId) {
		TheftDetection theftDetection = theftDetectionDao.getTheftDetection(deviceId);
		if (theftDetection != null) {
			List<SafeArea> safeAreas = safeAreaDao.getSafeAreas(theftDetection.getId());
			for (SafeArea safeArea : safeAreas) {
				if (safeArea.isEnabled())
					return safeArea.toSafeAreaObject();
			}
		}
		return null;
	}

}
