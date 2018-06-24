package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.RouteArea;

@Transactional
@Repository
public class RouteAreaDaoImpl extends BaseDaoImp<RouteArea> implements RouteAreaDao {
	public Class<RouteArea> getType() {
		return RouteArea.class;
	}
}