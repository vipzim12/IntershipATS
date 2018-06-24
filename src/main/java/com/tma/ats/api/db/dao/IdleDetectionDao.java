package com.tma.ats.api.db.dao;

import java.util.Date;
import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.IdleDetection;
import com.tma.ats.api.db.entity.Position;

public interface IdleDetectionDao extends BaseDao<IdleDetection> {
	IdleDetection getIdleDetection(String deviceId);
	
	List<Position> getPositions(Double duration, Date receivedTime);
}