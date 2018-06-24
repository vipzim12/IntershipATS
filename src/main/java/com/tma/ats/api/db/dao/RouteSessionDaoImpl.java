package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.RouteSession;

@Transactional
@Repository
public class RouteSessionDaoImpl extends BaseDaoImp<RouteSession> implements RouteSessionDao {
	public Class<RouteSession> getType() {
		return RouteSession.class;
	}
}
