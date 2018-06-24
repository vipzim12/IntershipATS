package com.tma.ats.api.db.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.Asset;

@Transactional
@Repository
public class AssetDaoImpl extends BaseDaoImp<Asset> implements AssetDao {
	
	public Class<Asset> getType() {
		return Asset.class;
	}

	@Override
	public Asset getAssetByDeviceId(String deviceId) {
		String sql = "FROM " + getType().getSimpleName() +
				     " WHERE deviceId = :deviceId";
		Query query = em.createQuery(sql);
		query.setParameter("deviceId", deviceId);
		return (Asset) query.getSingleResult();
	}

	@Override
	public List<Asset> getAllAssetInTrouble() {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " asset WHERE asset.deviceId IN (SELECT MAX(p.id) "
				+ "FROM " + getType().getSimpleName()
				+ " p GROUP BY p.deviceId)";
		sql += whereClause;
		Query query = em.createQuery(sql);
		return query.getResultList();
	}
}
