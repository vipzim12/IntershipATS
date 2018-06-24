package com.tma.ats.api.db.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tma.ats.api.core.db.dao.BaseDaoImp;
import com.tma.ats.api.db.entity.POIType;

@Transactional
@Repository
public class POITypeDaoImpl extends BaseDaoImp<POIType> implements POITypeDao {
	public Class<POIType> getType() {
		return POIType.class;
	}
}