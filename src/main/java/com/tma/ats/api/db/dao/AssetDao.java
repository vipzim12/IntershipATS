package com.tma.ats.api.db.dao;

import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.Asset;

public interface AssetDao extends BaseDao<Asset> {
	public Asset getAssetByDeviceId(String deviceId);
	public List<Asset> getAllAssetInTrouble();
}