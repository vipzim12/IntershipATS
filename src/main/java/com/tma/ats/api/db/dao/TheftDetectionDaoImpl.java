package com.tma.ats.api.db.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.TheftDetection;

@Transactional
@Repository
public class TheftDetectionDaoImpl extends BaseDaoImp<TheftDetection> implements TheftDetectionDao {
	public Class<TheftDetection> getType() {
		return TheftDetection.class;
	}

	@Override
	public TheftDetection getTheftDetection(String deviceId) {
		String sql = "FROM " + getType().getSimpleName() + " WHERE deviceId = :deviceId";
		Query query = em.createQuery(sql);
		query.setParameter("deviceId", deviceId);
		if (query.getResultList().size() == 0)
			return null;
		return (TheftDetection) query.getSingleResult();
	}
}
