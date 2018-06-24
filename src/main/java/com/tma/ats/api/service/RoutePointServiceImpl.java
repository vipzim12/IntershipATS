package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.RoutePointConverter;
import com.tma.ats.api.db.dao.RouteDao;
import com.tma.ats.api.db.dao.RoutePointDao;
import com.tma.ats.api.db.entity.Route;
import com.tma.ats.api.db.entity.RoutePoint;
import com.tma.ats.api.dto.RoutePointCreationAttributes;
import com.tma.ats.api.dto.RoutePointObject;

@Service
public class RoutePointServiceImpl implements RoutePointService {

	@Autowired
	private RoutePointDao routePointDao;
	@Autowired
	private RouteDao routeDao;

	private RoutePointConverter routePointConverter = new RoutePointConverter();

	@Override
	public List<RoutePointObject> getRoutePointsByRoute(Long objectId) {
		List<RoutePointObject> result = new ArrayList<RoutePointObject>();
		List<RoutePoint> routePoints = new ArrayList<RoutePoint>();
		if (objectId == null) {
			routePoints = routePointDao.list();
		} else {
			Route route = routeDao.read(objectId);
			if ((route == null) || (route.getRoutePoints() == null)) {
				return null;
			}
			routePoints = route.getRoutePoints();
		}
		for (RoutePoint routePoint : routePoints) {
			result.add(routePointConverter.convert(routePoint));
		}
		return result;
	}

	@Override
	public List<RoutePointObject> createRoutePoint(List<RoutePointCreationAttributes> attributes) {
		List<RoutePointObject> results = new ArrayList<RoutePointObject>();
		for (int i = 0; i < attributes.size() - 1; i++) {
			if ((attributes.get(i).getLatitude().compareTo(attributes.get(i + 1).getLatitude()) != 0)
					|| (attributes.get(i).getLongitude().compareTo(attributes.get(i + 1).getLongitude()) != 0)) {
				RoutePoint routePoint = new RoutePoint();
				routePoint.setLatitude(attributes.get(i).getLatitude());
				routePoint.setLongitude(attributes.get(i).getLongitude());
				routePoint.setRoute(routeDao.read(attributes.get(i).getRoute().getObjectId()));
				routePoint.setStamp(0);
				routePoint = routePointDao.create(routePoint);
				results.add(routePointConverter.convert(routePoint));
			}
		}
		return results;
	}

}
