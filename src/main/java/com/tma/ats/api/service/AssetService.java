package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.AssetCreationAttributes;
import com.tma.ats.api.dto.AssetInTroubleObject;
import com.tma.ats.api.dto.AssetModifiableAttributes;
import com.tma.ats.api.dto.AssetObject;

public interface AssetService {
	public AssetObject getAsset(Long objectId);

	public AssetObject createAsset(AssetCreationAttributes attributes);

	public AssetObject modifyAsset(AssetModifiableAttributes attributes);

	public void deleteAsset(Long objectId);

	public List<AssetObject> getAllAssets();

	public AssetObject getAssetByDeviceId(String deviceId);

	public void requestPositionUpdate(String deviceId);
	
	public void requestStatusUpdate(String deviceId);
	
	public int getMessagesInQueue(String deviceId);
	
	public List<AssetInTroubleObject> getAllAssetsInTrouble();
	
	public List<AssetObject> getAssetsByFleet(Long objectId);
	
	void moveAssetsToFleet(Long fleetId, List<Long> assetIds);
}
