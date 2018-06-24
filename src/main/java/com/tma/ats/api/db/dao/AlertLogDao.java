package com.tma.ats.api.db.dao;

import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.AlertLog;

public interface AlertLogDao extends BaseDao<AlertLog> {
	public List<AlertLog> getAlertLogsByAlertId(long alertId);
}
