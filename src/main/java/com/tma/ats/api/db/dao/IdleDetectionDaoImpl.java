package com.tma.ats.api.db.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.IdleDetection;
import com.tma.ats.api.db.entity.Position;

@Transactional
@Repository
public class IdleDetectionDaoImpl extends BaseDaoImp<IdleDetection> implements IdleDetectionDao {
	public Class<IdleDetection> getType() {
		return IdleDetection.class;
	}

	@Override
	public IdleDetection getIdleDetection(String deviceId) {
		String sql = "FROM " + getType().getSimpleName() + " WHERE deviceId = :deviceId";
		Query query = em.createQuery(sql);
		query.setParameter("deviceId", deviceId);
		if (query.getResultList().size() == 0)
			return null;
		return (IdleDetection) query.getSingleResult();
	}

	@Override
	public List<Position> getPositions(Double duration, Date receivedTime) {
		// TODO Auto-generated method stub
		return null;
	}
}
