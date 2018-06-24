package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.AlertStatus;

@Transactional
@Repository
public class AlertStatusDaoImpl extends BaseDaoImp<AlertStatus> implements AlertStatusDao {
	public Class<AlertStatus> getType() {
		return AlertStatus.class;
	}
}