package com.tma.ats.api.db.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.SafeArea;

@Transactional
@Repository
public class SafeAreaDaoImpl extends BaseDaoImp<SafeArea> implements SafeAreaDao {
	@Override
	public Class<SafeArea> getType() {
		return SafeArea.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SafeArea> getSafeAreas(long theftDetectionId) {
		String sql = "FROM " + getType().getSimpleName();
		String whereClause = " safeArea WHERE safeArea.theftDetection.id = :theft_Detection_Id)";
		sql += whereClause;
		Query query = em.createQuery(sql);
		query.setParameter("theft_Detection_Id", theftDetectionId);
		if (query.getResultList().size() == 0)
			return null;
		return query.getResultList();
	}
}
