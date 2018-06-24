package com.tma.ats.api.db.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.Alert;

@Transactional
@Repository
public class AlertDaoImpl extends BaseDaoImp<Alert> implements AlertDao {
	
	public Class<Alert> getType() {
		return Alert.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alert> getAllAlerts() {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " alert where alert.resolved = false";
		sql += whereClause;
		Query query = em.createQuery(sql);
		if(query.getResultList().size()==0)
			return null;
		return (List<Alert>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alert> getAlertsByDeviceId(String deviceId) {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " alert WHERE alert.deviceId = :device_Id and alert.resolved = false";
		sql += whereClause;
		Query query = em.createQuery(sql);
		query.setParameter("device_Id", deviceId);
		if(query.getResultList().size()==0)
			return null;
		return (List<Alert>) query.getResultList();
	}
}
