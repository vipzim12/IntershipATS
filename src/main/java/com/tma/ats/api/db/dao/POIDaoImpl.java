package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.POI;

@Transactional
@Repository
public class POIDaoImpl extends BaseDaoImp<POI> implements POIDao {
	public Class<POI> getType() {
		return POI.class;
	}
}