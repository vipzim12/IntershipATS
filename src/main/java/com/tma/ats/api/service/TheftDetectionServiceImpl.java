package com.tma.ats.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.AlertTypeDao;
import com.tma.ats.api.db.dao.TheftDetectionDao;
import com.tma.ats.api.db.entity.AlertType;
import com.tma.ats.api.db.entity.TheftDetection;
import com.tma.ats.api.dto.TheftDetectionCreationAttributes;
import com.tma.ats.api.dto.TheftDetectionModifiableAttributes;
import com.tma.ats.api.dto.TheftDetectionObject;
import com.tma.ats.api.dto.TheftDetectionObjectDTO;

@Service
public class TheftDetectionServiceImpl implements TheftDetectionService {

	@Autowired
	private TheftDetectionDao theftDetectionDao;
	@Autowired
	private AlertTypeDao alertTypeDao;

	@Override
	public TheftDetectionObject getTheftDetection(String deviceId) {
		TheftDetection theft = theftDetectionDao.getTheftDetection(deviceId);
		if (theft == null) {
			return null;
		}
		return theft.toTheftDetectionObject();
	}

	@Override
	public TheftDetectionObject modifyTheftDetection(TheftDetectionModifiableAttributes attributes) {
		TheftDetection theftDetection = theftDetectionDao.read(attributes.getObjectId());

		if (theftDetection.getStamp() != attributes.getStamp()) {
			return null;
		}

		theftDetection.setPriority(attributes.getPriority());
		theftDetection.setMessage(attributes.getMessage());
		theftDetection.setMail(attributes.getMail());
		theftDetection.setStamp(attributes.getStamp() + 1);
		theftDetection.setEnabled(attributes.isEnabled());

		theftDetection = theftDetectionDao.update(theftDetection);

		TheftDetectionObject theftDetectionObject = new TheftDetectionObjectDTO(theftDetection.getId(),
				theftDetection.getStamp(), theftDetection.getDeviceId(), theftDetection.getPriority(),
				theftDetection.getMessage(), theftDetection.getMail(),
				theftDetection.getAlertType().toAlertTypeObject(), theftDetection.isEnabled());

		return theftDetectionObject;
	}

	@Override
	public TheftDetectionObject createTheftDetection(TheftDetectionCreationAttributes attributes) {
		TheftDetection theftDetection = new TheftDetection();

		long id = 1;
		AlertType alertType = alertTypeDao.read(id);

		theftDetection.setDeviceId(attributes.getDeviceId());
		theftDetection.setPriority(attributes.getPriority());
		theftDetection.setMessage(attributes.getMessage());
		theftDetection.setMail(attributes.getMail());
		theftDetection.setAlertType(alertType);
		theftDetection.setStamp(0);

		theftDetection = theftDetectionDao.create(theftDetection);

		return theftDetection.toTheftDetectionObject();
	}

	@Override
	public TheftDetectionObject setEnabledTheftDetection(String deviceId) {
		TheftDetection theft = theftDetectionDao.getTheftDetection(deviceId);
		if (theft.isEnabled())
			theft.setEnabled(false);
		else
			theft.setEnabled(true);
		return theft.toTheftDetectionObject();
	}

}
