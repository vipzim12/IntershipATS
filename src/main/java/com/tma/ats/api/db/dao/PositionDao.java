package com.tma.ats.api.db.dao;

import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.Position;

public interface PositionDao extends BaseDao<Position> {
	List<Position> getAllPositions();

	Position getPositionByDeviceId(String deviceId);
	
	List<Position> getPositionsByDeviceIds(List<String> deviceIds);

	List<Position> getPositionsByDeviceId(String deviceId);
}