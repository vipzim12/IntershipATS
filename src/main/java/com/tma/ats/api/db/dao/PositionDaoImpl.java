package com.tma.ats.api.db.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.Position;

@Transactional
@Repository
public class PositionDaoImpl extends BaseDaoImp<Position> implements PositionDao {
	public Class<Position> getType() {
		return Position.class;
	}

	@Override
	public Position getPositionByDeviceId(String deviceId) {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " pos WHERE pos.deviceId = :device_Id AND "
				+ "pos.id IN (SELECT asset.lastPositionId FROM Asset asset)";
		sql += whereClause;
		Query query = em.createQuery(sql);
		query.setParameter("device_Id", deviceId);
		if (query.getResultList().isEmpty())
			return null;
		return (Position) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getAllPositions() {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " pos WHERE pos.id IN (SELECT asset.lastPositionId FROM Asset asset)";
		sql += whereClause;
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getPositionsByDeviceIds(List<String> deviceIds) {
		int count = 1;
		String deviceIdList = "(";
		for (String deviceId : deviceIds) {
			if (count != deviceIds.size())
				deviceIdList = deviceIdList + "'" + deviceId + "'" + ",";
			else
				deviceIdList = deviceIdList + "'" + deviceId + "'" + ")";
			count++;
		}
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " pos WHERE pos.deviceId IN " + deviceIdList
				+ " AND pos.id IN (SELECT asset.lastPositionId FROM Asset asset)";
		sql += whereClause;
		Query query = em.createQuery(sql);
		return (List<Position>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getPositionsByDeviceId(String deviceId) {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " pos WHERE pos.deviceId = :device_Id";
		sql += whereClause;
		Query query = em.createQuery(sql);
		query.setParameter("device_Id", deviceId);
		return (List<Position>) query.getResultList();
	}
}