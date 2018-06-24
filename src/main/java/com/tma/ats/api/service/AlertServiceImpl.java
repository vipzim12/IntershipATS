package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.AlertDao;
import com.tma.ats.api.db.dao.AlertLogDao;
import com.tma.ats.api.db.dao.AlertStatusDao;
import com.tma.ats.api.db.dao.AlertTypeDao;
import com.tma.ats.api.db.dao.AssetDao;
import com.tma.ats.api.db.dao.TheftDetectionDao;
import com.tma.ats.api.db.entity.Alert;
import com.tma.ats.api.db.entity.AlertAckState;
import com.tma.ats.api.db.entity.AlertLog;
import com.tma.ats.api.db.entity.AlertStatus;
import com.tma.ats.api.db.entity.AlertType;
import com.tma.ats.api.db.entity.Asset;
import com.tma.ats.api.db.entity.EventType;
import com.tma.ats.api.db.entity.TheftDetection;
import com.tma.ats.api.dto.AlertModifiableAttributes;
import com.tma.ats.api.dto.AlertObject;
import com.tma.ats.api.dto.AlertObjectDTO;
import com.tma.ats.api.dto.AssetInTroubleObject;
import com.tma.ats.api.dto.UiAlertTypeObject;

@Service
public class AlertServiceImpl implements AlertService {

	@Autowired
	private AlertDao alertDao;
	@Autowired
	private AlertTypeDao alertTypeDao;
	@Autowired
	private AssetDao assetDao;
	@Autowired
	private TheftDetectionDao theftDetectionDao;
	@Autowired
	private AlertLogDao alertLogDao;
	@Autowired
	private AlertStatusDao alertStatusDao;

	@Override
	public List<AlertObject> getAllAlerts() {
		List<Alert> alerts = new ArrayList<Alert>();
		alerts = alertDao.getAllAlerts();
		List<AlertObject> alertObjects = new ArrayList<AlertObject>();
		if (alerts != null) {
			for (Alert alert : alerts) {
				alertObjects.add(alert.toAlertObject());
			}
		}
		return alertObjects;
	}

	@Override
	public List<UiAlertTypeObject> getAlertsTypeOfAlert(AssetInTroubleObject assetInTrouble) {

		List<UiAlertTypeObject> uiAlertTypes = new ArrayList<UiAlertTypeObject>();
		Asset asset = assetDao.read(assetInTrouble.getObjectId());
		List<Alert> alerts = alertDao.getAlertsByDeviceId(asset.getDeviceId());
		for (Alert alert : alerts) {
			String messageHistory = "";
			List<AlertLog> alertLogs = alertLogDao.getAlertLogsByAlertId(alert.getId());
			if (alertLogs != null)
				for (AlertLog alertLog : alertLogs) {
					messageHistory += alertLog.toAlertLogObject().toString();
				}
			int priority = 1;
			if (alert.getAlertType().getId() == 1) {
				TheftDetection theftDetection = theftDetectionDao.getTheftDetection(alert.getDeviceId());
				priority = theftDetection.getPriority();
			}
			UiAlertTypeObject uiAlertType = new UiAlertTypeObject(alert.getId(), alert.getAlertType().getName(),
					alert.getAlertType().getDescription(), alert.getAlertStatus().getStatus(), priority,
					alert.getRaisedTime(), alert.getAcknowledgedBy(), alert.getAlertAckState(), messageHistory);
			uiAlertTypes.add(uiAlertType);
			System.out.println(uiAlertType.toString());
		}
		return uiAlertTypes;
	}

	@Override
	public AlertObject resolveAlert(AlertModifiableAttributes attr) {
		Date date = new Date();
		Alert alert = alertDao.read(attr.getObjectId());
		alert.setResolveTime(date);
		alert.setResolveMessage(attr.getMessage());
		alert.setResolved(true);
		alert = alertDao.update(alert);

		AlertLog alertLog = new AlertLog();
		alertLog.setEventType(EventType.Resolved);
		alertLog.setEventTime(date);
		alertLog.setMessage(attr.getMessage());
		alertLog.setAlert(alert);
		alertLog = alertLogDao.create(alertLog);

		AlertObject alertObject = alert.toAlertObject();
		return alertObject;
	}

	@Override
	public AlertObject acknowledgeAlert(AlertModifiableAttributes attr) {
		Date date = new Date();
		Alert alert = alertDao.read(attr.getObjectId());
		alert.setAlertAckState(AlertAckState.Acknowledged);
		alert.setAcknowledgedBy("admin");
		alert = alertDao.update(alert);

		AlertLog alertLog = new AlertLog();
		alertLog.setEventType(EventType.Acknowledged);
		alertLog.setEventTime(date);
		alertLog.setMessage(attr.getMessage());
		alertLog.setAlert(alert);
		alertLog = alertLogDao.create(alertLog);

		AlertObject alertObject = alert.toAlertObject();
		return alertObject;
	}

	@Override
	public AlertObject createAlertByTheftDetection(String deviceId) {
		AlertType alertType = new AlertType();
		AlertStatus alertStatus = new AlertStatus();
		long id = 1;
		alertType = alertTypeDao.read(id);
		alertStatus = alertStatusDao.read(id);
		Date date = new Date();
		Alert alert = new Alert();
		alert.setDeviceId(deviceId);
		alert.setStamp(0);
		alert.setAlertAckState(AlertAckState.Unacknowledged);
		alert.setRaisedTime(date);
		alert.setAlertType(alertType);
		alert.setAlertStatus(alertStatus);

		List<Alert> alerts = new ArrayList<Alert>();
		alerts = alertDao.getAlertsByDeviceId(deviceId);
		if (alerts == null) {
			alert = alertDao.create(alert);
			AlertObject alertObject = new AlertObjectDTO(alert.getId(), alert.getStamp(), alert.getDeviceId(),
					alert.getAlertAckState(), alert.getRaisedTime(), alert.getAcknowledgedBy(), alert.isResolved(),
					alert.getResolveTime(), alert.getResolveMessage(), alert.getAlertType().toAlertTypeObject(),
					alert.getAlertStatus().toAlertStatusObject());

			AlertLog alertLog = new AlertLog();
			alertLog.setEventType(EventType.Raised);
			alertLog.setEventTime(date);
			alertLog.setMessage("The device is out of safe area");
			alertLog.setAlert(alert);
			alertLog = alertLogDao.create(alertLog);

			return alertObject;
		}
		return null;
	}

	@Override
	public AlertObject createAlertByOutOfRoute(String deviceId) {
		AlertType alertType = new AlertType();
		AlertStatus alertStatus = new AlertStatus();
		long alertTypeId = 2;
		long alertStatusId = 1;
		alertType = alertTypeDao.read(alertTypeId);
		alertStatus = alertStatusDao.read(alertStatusId);
		Date date = new Date();
		Alert alert = new Alert();
		alert.setDeviceId(deviceId);
		alert.setStamp(0);
		alert.setAlertAckState(AlertAckState.Unacknowledged);
		alert.setRaisedTime(date);
		alert.setAlertType(alertType);
		alert.setAlertStatus(alertStatus);

		List<Alert> alerts = new ArrayList<Alert>();
		alerts = alertDao.getAlertsByDeviceId(deviceId);
		if (alerts == null) {
			alert = alertDao.create(alert);
			AlertObject alertObject = new AlertObjectDTO(alert.getId(), alert.getStamp(), alert.getDeviceId(),
					alert.getAlertAckState(), alert.getRaisedTime(), alert.getAcknowledgedBy(), alert.isResolved(),
					alert.getResolveTime(), alert.getResolveMessage(), alert.getAlertType().toAlertTypeObject(),
					alert.getAlertStatus().toAlertStatusObject());

			AlertLog alertLog = new AlertLog();
			alertLog.setEventType(EventType.Raised);
			alertLog.setEventTime(date);
			alertLog.setMessage("The device is out of route");
			alertLog.setAlert(alert);
			alertLog = alertLogDao.create(alertLog);

			return alertObject;
		}
		return null;
	}

	@Override
	public List<AlertObject> getAlertsByType(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
