package com.tma.ats.api.db.dao;

import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.Alert;


public interface AlertDao extends BaseDao<Alert> {
	public List<Alert> getAllAlerts();
	public List<Alert> getAlertsByDeviceId(String deviceId);
}
