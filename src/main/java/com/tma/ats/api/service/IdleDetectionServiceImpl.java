package com.tma.ats.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.IdleDetectionConverter;
import com.tma.ats.api.db.dao.AlertTypeDao;
import com.tma.ats.api.db.dao.IdleDetectionDao;
import com.tma.ats.api.db.entity.AlertType;
import com.tma.ats.api.db.entity.IdleDetection;
import com.tma.ats.api.dto.IdleDetectionCreationAttributes;
import com.tma.ats.api.dto.IdleDetectionModifiableAttributes;
import com.tma.ats.api.dto.IdleDetectionObject;

@Service
public class IdleDetectionServiceImpl implements IdleDetectionService {

	@Autowired
	private IdleDetectionDao idleDetectionDao;
	@Autowired
	private AlertTypeDao alertTypeDao;

	private IdleDetectionConverter idleDetectionConverter = new IdleDetectionConverter();

	@Override
	public IdleDetectionObject getIdleDetection(String deviceId) {
		IdleDetection idleDetection = idleDetectionDao.getIdleDetection(deviceId);
		if (idleDetection == null) {
			return null;
		}
		return idleDetectionConverter.convert(idleDetection);
	}

	@Override
	public IdleDetectionObject modifyIdleDetection(IdleDetectionModifiableAttributes attributes) {
		IdleDetection idleDetection = idleDetectionDao.read(attributes.getObjectId());

		if (idleDetection.getStamp() != attributes.getStamp()) {
			return null;
		}

		idleDetection.setPriority(attributes.getPriority());
		idleDetection.setMessage(attributes.getMessage());
		idleDetection.setMail(attributes.getMail());
		idleDetection.setStamp(attributes.getStamp() + 1);
		idleDetection.setRadius(attributes.getRadius());
		idleDetection.setDuration(attributes.getDuration());
		idleDetection = idleDetectionDao.update(idleDetection);

		return idleDetectionConverter.convert(idleDetection);
	}

	@Override
	public IdleDetectionObject createIdleDetection(IdleDetectionCreationAttributes attributes) {
		IdleDetection idleDetection = new IdleDetection();

		AlertType alertType = alertTypeDao.read(new Long(3));
		idleDetection.setAlertType(alertType);
		idleDetection.setDeviceId(attributes.getDeviceId());
		idleDetection.setPriority(attributes.getPriority());
		idleDetection.setMessage(attributes.getMessage());
		idleDetection.setMail(attributes.getMail());
		idleDetection.setStamp(0);
		idleDetection.setRadius(attributes.getRadius());
		idleDetection.setDuration(attributes.getDuration());
		idleDetection = idleDetectionDao.create(idleDetection);

		return idleDetectionConverter.convert(idleDetection);
	}

	@Override
	public IdleDetectionObject setEnabledIdleDetection(Long id) {
		IdleDetection idleDetection = idleDetectionDao.read(id);
		if (idleDetection.isEnabled())
			idleDetection.setEnabled(false);
		else
			idleDetection.setEnabled(true);
		return idleDetectionConverter.convert(idleDetection);
	}

}
