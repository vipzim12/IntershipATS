package com.tma.ats.api.db.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.Queue;

@Transactional
@Repository
public class QueueDaoImpl extends BaseDaoImp<Queue> implements QueueDao {
	@Override
	public Class<Queue> getType() {
		return Queue.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Queue> getQueues(String deviceId) {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " que WHERE que.deviceId = :device_Id)";
		sql += whereClause;
		Query query = em.createQuery(sql);
		query.setParameter("device_Id", deviceId);
		return query.getResultList();
	}
}
