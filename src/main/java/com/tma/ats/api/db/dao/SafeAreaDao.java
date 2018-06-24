package com.tma.ats.api.db.dao;

import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.SafeArea;

public interface SafeAreaDao extends BaseDao<SafeArea> {
	public List<SafeArea> getSafeAreas(long theftDetectionId);
}
