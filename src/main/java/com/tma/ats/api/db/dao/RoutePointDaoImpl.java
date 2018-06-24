package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.RoutePoint;

@Transactional
@Repository
public class RoutePointDaoImpl extends BaseDaoImp<RoutePoint> implements RoutePointDao {
	public Class<RoutePoint> getType() {
		return RoutePoint.class;
	}
}
