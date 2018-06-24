package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.Fleet;

@Transactional
@Repository
public class FleetDaoImpl extends BaseDaoImp<Fleet> implements FleetDao {
	public Class<Fleet> getType() {
		return Fleet.class;
	}
}
