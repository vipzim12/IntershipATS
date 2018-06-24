package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.Route;

@Transactional
@Repository
public class RouteDaoImpl extends BaseDaoImp<Route> implements RouteDao {
	public Class<Route> getType() {
		return Route.class;
	}
}
