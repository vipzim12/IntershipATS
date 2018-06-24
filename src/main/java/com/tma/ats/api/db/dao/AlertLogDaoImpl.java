package com.tma.ats.api.db.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.AlertLog;

@Transactional
@Repository
public class AlertLogDaoImpl extends BaseDaoImp<AlertLog> implements AlertLogDao {
	
	public Class<AlertLog> getType() {
		return AlertLog.class;
	}

	@Override
	public List<AlertLog> getAlertLogsByAlertId(long alertId) {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " log WHERE log.alert.id = :alert_Id";
		sql += whereClause;
		Query query = em.createQuery(sql);
		query.setParameter("alert_Id", alertId);
		if(query.getResultList().size()==0)
			return null;
		return (List<AlertLog>) query.getResultList();
	}
}
