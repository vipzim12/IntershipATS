package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.AssetConverter;
import com.tma.ats.api.converter.RouteSessionConverter;
import com.tma.ats.api.db.dao.AssetDao;
import com.tma.ats.api.db.dao.RouteDao;
import com.tma.ats.api.db.dao.RouteSessionDao;
import com.tma.ats.api.db.entity.Asset;
import com.tma.ats.api.db.entity.Route;
import com.tma.ats.api.db.entity.RouteSession;
import com.tma.ats.api.dto.AssetObject;
import com.tma.ats.api.dto.RouteSessionCreationAttributes;
import com.tma.ats.api.dto.RouteSessionModifiableAttributes;
import com.tma.ats.api.dto.RouteSessionObject;

@Service
public class RouteSessionServiceImpl implements RouteSessionService {

	@Autowired
	private RouteSessionDao routeSessionDao;
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private AssetDao assetDao;

	private RouteSessionConverter routeSessionConverter = new RouteSessionConverter();
	private AssetConverter assetConverter = new AssetConverter();

	@Override
	public List<RouteSessionObject> getRouteSessionsByRoute(Long objectId) {
		List<RouteSessionObject> result = new ArrayList<RouteSessionObject>();
		List<RouteSession> routeSessions = new ArrayList<RouteSession>();
		if (objectId == null) {
			routeSessions = routeSessionDao.list();
		} else {
			Route route = routeDao.read(objectId);
			if ((route == null) || (route.getRouteSessions() == null)) {
				return null;
			}
			routeSessions = route.getRouteSessions();
		}
		for (RouteSession routeSession : routeSessions) {
			result.add(routeSessionConverter.convert(routeSession));
		}
		return result;
	}

	@Override
	public RouteSessionObject getRouteSession(long objectId) {
		RouteSession routeSession = routeSessionDao.read(objectId);
		if (routeSession == null) {
			return null;
		}
		return routeSessionConverter.convert(routeSession);
	}

	@Override
	public List<AssetObject> getAssetsByRouteSession(Long objectId) {
		RouteSession routeSession = routeSessionDao.read(objectId);
		if ((routeSession == null) || (routeSession.getAssets() == null)) {
			return null;
		}
		List<Asset> assets = routeSession.getAssets();
		List<AssetObject> results = new ArrayList<AssetObject>();
		for (Asset asset : assets) {
			results.add(assetConverter.convert(asset));
		}
		return results;
	}

	@Override
	public RouteSessionObject createRouteSession(RouteSessionCreationAttributes attributes) {
		RouteSession routeSession = new RouteSession();

		routeSession.setName(attributes.getName());
		routeSession.setDescription(attributes.getDescription());
		routeSession.setCompleted(false);
		routeSession.setSafeDistance(attributes.getSafeDistance());
		routeSession.setStamp(0);
		routeSession.setRoute(routeDao.read(attributes.getRoute().getObjectId()));

		routeSession = routeSessionDao.create(routeSession);
		return routeSessionConverter.convert(routeSession);
	}

	@Override
	public void addAssetsToRouteSession(Long routeSessionId, List<Long> assetIds) {
		RouteSession routeSession = routeSessionDao.read(routeSessionId);
		List<Asset> assets = routeSession.getAssets();

		for (Long id : assetIds) {
			Asset asset = assetDao.read(id);
			assets.add(asset);
		}

		routeSession.setAssets(assets);
	}

	@Override
	public RouteSessionObject changeStateRouteSession(RouteSessionModifiableAttributes attributes) {
		RouteSession routeSession = routeSessionDao.read(attributes.getObjectId());
		if (routeSession.getStamp() != attributes.getStamp()) {
			return null;
		}
		routeSession.setName(attributes.getName());
		routeSession.setStartTime(attributes.getStartTime());
		routeSession.setEndTime(attributes.getEndTime());
		routeSession.setDescription(attributes.getDescription());
		routeSession.setSafeDistance(attributes.getSafeDistance());
		routeSession.setStamp(attributes.getStamp() + 1);
		routeSession.setCompleted(attributes.isCompleted());

		routeSession = routeSessionDao.update(routeSession);
		return routeSessionConverter.convert(routeSession);
	}

	@Override
	public void removeAssetsFromRouteSession(Long routeSessionId, List<Long> assetIds) {
		RouteSession routeSession = routeSessionDao.read(routeSessionId);
		List<Asset> assets = routeSession.getAssets();

		for (Long id : assetIds) {
			Asset asset = assetDao.read(id);
			assets.remove(asset);
		}

		routeSession.setAssets(assets);
	}

}
