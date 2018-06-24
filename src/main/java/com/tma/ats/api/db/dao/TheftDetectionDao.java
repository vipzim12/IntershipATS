package com.tma.ats.api.db.dao;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.TheftDetection;

public interface TheftDetectionDao extends BaseDao<TheftDetection> {
	TheftDetection getTheftDetection(String deviceId);
}
