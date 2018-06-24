package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.AssetConverter;
import com.tma.ats.api.db.dao.AlertDao;
import com.tma.ats.api.db.dao.AssetDao;
import com.tma.ats.api.db.dao.FleetDao;
import com.tma.ats.api.db.dao.QueueDao;
import com.tma.ats.api.db.dao.TheftDetectionDao;
import com.tma.ats.api.db.entity.Alert;
import com.tma.ats.api.db.entity.Asset;
import com.tma.ats.api.db.entity.BatteryLevel;
import com.tma.ats.api.db.entity.DeviceStatus;
import com.tma.ats.api.db.entity.Fleet;
import com.tma.ats.api.db.entity.MessageType;
import com.tma.ats.api.db.entity.Queue;
import com.tma.ats.api.db.entity.TheftDetection;
import com.tma.ats.api.dto.AssetCreationAttributes;
import com.tma.ats.api.dto.AssetInTroubleObject;
import com.tma.ats.api.dto.AssetModifiableAttributes;
import com.tma.ats.api.dto.AssetObject;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetDao assetDao;
	@Autowired
	private QueueDao queueDao;
	@Autowired
	private AlertDao alertDao;
	@Autowired
	private TheftDetectionDao theftDetectionDao;
	@Autowired
	private FleetDao fleetDao;

	private AssetConverter converter = new AssetConverter();

	@Override
	public AssetObject getAsset(Long objectId) {
		return null;
	}

	@Override
	public AssetObject createAsset(AssetCreationAttributes attributes) {
		Asset asset = new Asset();
		asset.setSerialNo(attributes.getSerialNo());
		asset.setIdentifier(attributes.getIdentifier());
		asset.setDescription(attributes.getDescription());
		asset.setDeviceId(attributes.getDeviceId());
		asset.setProduct(attributes.getProduct());
		asset.setStamp(0);
		asset.setBatteryLevel(BatteryLevel.UNKNOWN);
		asset.setDeviceStatus(DeviceStatus.UNKNOWN);
		asset.setFleet(fleetDao.read(attributes.getFleet().getObjectId()));
		asset = assetDao.create(asset);

		return converter.convert(asset);
	}

	@Override
	public AssetObject modifyAsset(AssetModifiableAttributes attributes) {
		Asset asset = assetDao.read(attributes.getObjectId());

		if (asset.getStamp() != attributes.getStamp()) {
			return null;
		}
		asset.setSerialNo(attributes.getSerialNo());
		asset.setDescription(attributes.getDescription());
		asset.setDeviceId(attributes.getDeviceId());
		asset.setProduct(attributes.getProduct());
		asset.setStamp(attributes.getStamp() + 1);
		asset = assetDao.update(asset);

		return converter.convert(asset);
	}

	@Override
	public void deleteAsset(Long objectId) {
		Asset asset = assetDao.read(objectId);
		if (asset != null) {
			assetDao.delete(asset);
		}
	}

	@Override
	public List<AssetObject> getAllAssets() {
		List<Asset> assets = assetDao.list();
		List<AssetObject> results = new ArrayList<AssetObject>();
		for (Asset asset : assets) {
			results.add(converter.convert(asset));
		}
		return results;
	}

	@Override
	public AssetObject getAssetByDeviceId(String deviceId) {
		Asset asset = assetDao.getAssetByDeviceId(deviceId);
		return converter.convert(asset);
	}

	@Override
	public void requestPositionUpdate(String deviceId) {
		Queue queue = new Queue();
		queue.setDeviceId(deviceId);
		queue.setMessageType(MessageType.L);
		queue.setMessage(null);
		queueDao.create(queue);

	}

	@Override
	public int getMessagesInQueue(String deviceId) {
		return queueDao.getQueues(deviceId).size();
	}

	@Override
	public void requestStatusUpdate(String deviceId) {
		Queue queue = new Queue();
		queue.setDeviceId(deviceId);
		queue.setMessageType(MessageType.V);
		queue.setMessage(null);
		queueDao.create(queue);
	}

	@Override
	public List<AssetInTroubleObject> getAllAssetsInTrouble() {
		List<AssetInTroubleObject> assetsInTrouble = new ArrayList<AssetInTroubleObject>();

		List<Alert> alerts = new ArrayList<Alert>();
		alerts = alertDao.getAllAlerts();
		if (alerts == null)
			return null;
		for (Alert alert : alerts) {
			Asset asset = assetDao.getAssetByDeviceId(alert.getDeviceId());
			int priority = 1;
			if (alert.getAlertType().getId() == 1) {
				TheftDetection theftDetection = theftDetectionDao.getTheftDetection(alert.getDeviceId());
				priority = theftDetection.getPriority();
			}
			AssetInTroubleObject assetInTrouble = new AssetInTroubleObject(asset.getId(), asset.getIdentifier(),
					alert.getAlertAckState(), priority, asset.getDeviceId());
			assetsInTrouble.add(assetInTrouble);
		}

		return assetsInTrouble;
	}

	@Override
	public List<AssetObject> getAssetsByFleet(Long objectId) {
		List<AssetObject> results = new ArrayList<AssetObject>();
		List<Asset> assets = new ArrayList<Asset>();
		if (objectId == null) {
			assets = assetDao.list();
		} else {
			Fleet fleet = fleetDao.read(objectId);
			if ((fleet == null) || (fleet.getAssets() == null)) {
				return null;
			}
			assets = fleet.getAssets();
		}
		for (Asset asset : assets) {
			results.add(converter.convert(asset));
		}
		return results;
	}

	@Override
	public void moveAssetsToFleet(Long fleetId, List<Long> assetIds) {
		for (Long id : assetIds) {
			Asset asset = assetDao.read(id);
			asset.setFleet(fleetDao.read(fleetId));
			assetDao.update(asset);
		}
	}

}
