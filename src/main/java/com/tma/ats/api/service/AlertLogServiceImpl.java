package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.AlertDao;
import com.tma.ats.api.db.dao.AlertLogDao;
import com.tma.ats.api.db.entity.Alert;
import com.tma.ats.api.db.entity.AlertLog;
import com.tma.ats.api.dto.AlertLogCreationAttributes;
import com.tma.ats.api.dto.AlertLogObject;
import com.tma.ats.api.dto.AlertLogObjectDTO;

@Service
public class AlertLogServiceImpl implements AlertLogService {

	@Autowired
	private AlertLogDao alertLogDao;
	@Autowired
	private AlertDao alertDao;

	@Override
	public AlertLogObject createAlertLog(AlertLogCreationAttributes attributes) {
		Alert alert = alertDao.read(attributes.getAlertId());
		AlertLog alertLog = new AlertLog();
		alertLog.setEventType(attributes.getEventType());
		alertLog.setEventTime(attributes.getEventTime());
		alertLog.setMessage(attributes.getMessage());
		alertLog.setAlert(alert);
		alertLog = alertLogDao.create(alertLog);

		AlertLogObject alertLogObject = new AlertLogObjectDTO(alertLog.getId(), alertLog.getEventType(),
				alertLog.getEventTime(), alertLog.getMessage(), alertLog.getAlert().toAlertObject());

		return alertLogObject;
	}

	@Override
	public List<AlertLogObject> getAlertLogs(long alertId) {
		List<AlertLog> alertLogs = alertLogDao.getAlertLogsByAlertId(alertId);
		List<AlertLogObject> alertLogObjects = new ArrayList<AlertLogObject>();
		for (AlertLog alertLog : alertLogs) {
			alertLogObjects.add(alertLog.toAlertLogObject());
		}
		return alertLogObjects;
	}

}
