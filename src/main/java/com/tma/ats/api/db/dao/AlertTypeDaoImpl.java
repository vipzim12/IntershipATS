package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.AlertType;

@Transactional
@Repository
public class AlertTypeDaoImpl extends BaseDaoImp<AlertType> implements AlertTypeDao {
	public Class<AlertType> getType() {
		return AlertType.class;
	}
}